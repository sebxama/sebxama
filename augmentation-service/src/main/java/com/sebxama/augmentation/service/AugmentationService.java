/*
* Copyright 2024 Sebastian Samaruga
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.sebxama.augmentation.service;

import org.eclipse.rdf4j.spring.support.RDF4JTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sebxama.augmentation.repository.ServiceRepository;
import com.sebxama.functional.model.Property;
import com.sebxama.functional.model.Statement;
import com.sebxama.functional.model.dto.Quad;
import com.sebxama.functional.model.objectmapper.deserializer.StatementDeserializer;
import com.sebxama.functional.service.IndexService;
import com.sebxama.functional.service.NamingService;
import com.sebxama.functional.service.RegistryService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AugmentationService {

	@Autowired
	RDF4JTemplate rdfTemplate;

	@Autowired
	ServiceRepository serviceRepository;

	@Autowired
	ObjectMapper objectMapper;
	
	IndexService indexService = IndexService.getInstance();
	
	NamingService namingService = NamingService.getInstance();
	
	RegistryService registryService = RegistryService.getInstance();

	@Autowired
	WebClient webClient;
	
	public Mono<Quad> perform(Quad in) {

		System.out.println("AugmentationService::perform");
		System.out.println(in);		
		Mono<Quad> stream = Mono.just(in);
		
		Statement s = registryService.getStatement(in);
		
		Property prop = new Property();
		prop.setURI(s.getContext().getOccurrenceURI());
		prop.setAttribute(registryService.getURI("SamplePropertyAttribute"));
		prop.setValue(registryService.getURI("SamplePropertyValue"));
		
		prop = new Property();
		prop.setURI(s.getSubject().getURI());
		prop.setAttribute(registryService.getURI("SamplePropertyAttribute2"));
		prop.setValue(registryService.getURI("SamplePropertyValue2"));
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String val = mapper.writeValueAsString(s);
			System.out.println("Serialized:");
			System.out.println(val);
			Statement st = mapper.readValue(val, Statement.class);
			System.out.println("Deserialized:");
			System.out.println(st);
			System.out.println(st.getContext().getOccurrenceURI().getProperties().iterator().next().getAttribute());
			System.out.println(st.getContext().getOccurrenceURI().getProperties().iterator().next().getValue());
			System.out.println(st.getSubject().getURI().getProperties().iterator().next().getAttribute());
			System.out.println(st.getSubject().getURI().getProperties().iterator().next().getValue());
			val = mapper.writeValueAsString(st);
			System.out.println("Serialized again:");
			System.out.println(val);
		} catch(Throwable t) {
			t.printStackTrace();
		}
		
		stream.flatMap(quad -> {
			System.out.println("Calling Aggregation...");
			Statement st = registryService.getStatement(quad);
			System.out.println(st);
			Mono<Statement> src = Mono.just(st);
			webClient
			.post()
			.uri("http://localhost:8383/aggregation/perform")
			.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
			.body(src, Statement.class)
			.retrieve()
			.bodyToMono(Statement.class)
			.flatMap(stat -> {
				registryService.putStatement(stat);
				System.out.println("Calling Alignment...");
				System.out.println(stat);
				Mono<Statement> src2 = Mono.just(stat);
				webClient
				.post()
				.uri("http://localhost:8484/alignment/perform")
				.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
				.body(src2, Statement.class)
				.retrieve()
				.bodyToMono(Statement.class)
				.flatMap(stat2 -> {
					registryService.putStatement(stat2);
					System.out.println("Calling Activation...");
					System.out.println(stat2);
					Mono<Statement> src3 = Mono.just(stat2);
					webClient
					.post()
					.uri("http://localhost:8585/activation/perform")
					.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
					.body(src3, Statement.class)
					.retrieve()
					.bodyToMono(Statement.class)
					.flatMap(stat3 -> {
						registryService.putStatement(stat3);
						return Mono.just(stat3);
					}).subscribe();	
					return Mono.just(stat2);
				}).subscribe();
				return Mono.just(stat);
			}).subscribe();
			return Mono.just(src);
		}).subscribe();
		
		return stream;
	}
	
}
