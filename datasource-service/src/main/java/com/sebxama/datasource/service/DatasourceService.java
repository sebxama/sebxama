package com.sebxama.datasource.service;

import java.util.Optional;
import java.util.function.Function;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.reactive.function.client.WebClient.UriSpec;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sebxama.datasource.model.Datasource;
import com.sebxama.datasource.repository.DatasourceRepository;
import com.sebxama.functional.model.dto.Quad;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DatasourceService {

	@Autowired
	DatasourceRepository datasourceRepository;

	@Autowired
	ReactiveKafkaProducerTemplate<String, String> rkpt;
	
	public Flux<Datasource> findByNameContaining(String nombre) {
		return datasourceRepository.findByNameContaining(nombre);
	}
	
	public Flux<Datasource> findAll() {
		return datasourceRepository.findAll();
	}

	public Mono<Datasource> findById(int id) {
		return datasourceRepository.findById(id);
	}

	public Mono<String> publishQuad(String topic, Quad quad) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			String quadStr = mapper.writeValueAsString(quad);
			rkpt.send(topic, "QUAD_PUBLISHED", quadStr).subscribe();
			return Mono.just(quadStr);
		} catch(Throwable t) {
			t.printStackTrace();
			return Mono.just(t.getMessage());
		}
	}

}
