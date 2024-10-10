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

package com.sebxama.alignment.service;

import org.eclipse.rdf4j.spring.support.RDF4JTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.sebxama.alignment.repository.ServiceRepository;
import com.sebxama.functional.model.Statement;
import com.sebxama.functional.service.IndexService;
import com.sebxama.functional.service.NamingService;
import com.sebxama.functional.service.RegistryService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AlignmentService {

	@Autowired
	RDF4JTemplate rdfTemplate;
	
	@Autowired
	ServiceRepository serviceRepository;

	@Autowired
	WebClient webClient;

	IndexService indexService = IndexService.getInstance();
	
	NamingService namingService = NamingService.getInstance();
	
	RegistryService registryService = RegistryService.getInstance();
	
	public Mono<Statement> perform(Statement stat) {
		// TODO
		System.out.println("AlignmentService::perform");
		System.out.println(stat);
		return Mono.just(stat);
	}
	
}
