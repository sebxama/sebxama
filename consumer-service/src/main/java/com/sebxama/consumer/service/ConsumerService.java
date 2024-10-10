package com.sebxama.consumer.service;

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
import com.sebxama.consumer.model.Espectador;
import com.sebxama.consumer.repository.ConsumerRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ConsumerService {

	@Autowired
	ConsumerRepository espectadorRepository;

	@Autowired
	ReactiveKafkaProducerTemplate<String, String> rkpt;
	
	public Flux<Espectador> findByNombreContaining(String nombre) {
		return espectadorRepository.findByNombreContaining(nombre);
	}
	
	public Flux<Espectador> findAll() {
		return espectadorRepository.findAll();
	}

	public Mono<Espectador> findById(int id) {
		return espectadorRepository.findById(id);
	}

	public Mono<Espectador> save(Espectador espectador) {
		ObjectMapper mapper = new ObjectMapper();
		return espectadorRepository.save(espectador).doOnSuccess(esp -> {
			try {
				rkpt.send("boleteria-topic", "ESPECTADOR_CREATED", mapper.writeValueAsString(esp)).subscribe();
				rkpt.send("cartelera-topic", "ESPECTADOR_CREATED", mapper.writeValueAsString(esp)).subscribe();
				rkpt.send("dashboard-topic", "ESPECTADOR_CREATED", mapper.writeValueAsString(esp)).subscribe();
				rkpt.send("espectador-topic", "ESPECTADOR_CREATED", mapper.writeValueAsString(esp)).subscribe();
				rkpt.send("funcion-topic", "ESPECTADOR_CREATED", mapper.writeValueAsString(esp)).subscribe();
				rkpt.send("pelicula-topic", "ESPECTADOR_CREATED", mapper.writeValueAsString(esp)).subscribe();
				rkpt.send("sala-topic", "ESPECTADOR_CREATED", mapper.writeValueAsString(esp)).subscribe();
			} catch(Throwable ex) {
				ex.printStackTrace();
			}
		});
	}

	public Mono<Espectador> update(Integer id, Espectador espectador) {
		ObjectMapper mapper = new ObjectMapper();
		return espectadorRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
				.flatMap(optionalFuncion -> {
					if (optionalFuncion.isPresent()) {
						espectador.setId(id);
						return espectadorRepository.save(espectador).doOnSuccess(esp -> {
							try {
								rkpt.send("boleteria-topic", "ESPECTADOR_UPDATED", mapper.writeValueAsString(esp)).subscribe();
								rkpt.send("cartelera-topic", "ESPECTADOR_UPDATED", mapper.writeValueAsString(esp)).subscribe();
								rkpt.send("dashboard-topic", "ESPECTADOR_UPDATED", mapper.writeValueAsString(esp)).subscribe();
								rkpt.send("espectador-topic", "ESPECTADOR_UPDATED", mapper.writeValueAsString(esp)).subscribe();
								rkpt.send("funcion-topic", "ESPECTADOR_UPDATED", mapper.writeValueAsString(esp)).subscribe();
								rkpt.send("pelicula-topic", "ESPECTADOR_UPDATED", mapper.writeValueAsString(esp)).subscribe();
								rkpt.send("sala-topic", "ESPECTADOR_UPDATED", mapper.writeValueAsString(esp)).subscribe();
							} catch(Throwable ex) {
								ex.printStackTrace();
							}
						});
					}
					return Mono.empty();
				});
	}

	public Mono<Void> deleteById(int id) {
		return espectadorRepository.deleteById(id).doOnSuccess(n -> {
			rkpt.send("boleteria-topic", "ESPECTADOR_DELETED", "{\"id\": "+id+"}").subscribe();
			rkpt.send("cartelera-topic", "ESPECTADOR_DELETED", "{\"id\": "+id+"}").subscribe();
			rkpt.send("dashboard-topic", "ESPECTADOR_DELETED", "{\"id\": "+id+"}").subscribe();
			rkpt.send("espectador-topic", "ESPECTADOR_DELETED", "{\"id\": "+id+"}").subscribe();
			rkpt.send("funcion-topic", "ESPECTADOR_DELETED", "{\"id\": "+id+"}").subscribe();
			rkpt.send("pelicula-topic", "ESPECTADOR_DELETED", "{\"id\": "+id+"}").subscribe();
			rkpt.send("sala-topic", "ESPECTADOR_DELETED", "{\"id\": "+id+"}").subscribe();
		});
	}

	public Mono<Void> deleteAll() {
		return espectadorRepository.deleteAll().doOnSuccess(n -> {
			rkpt.send("boleteria-topic", "ESPECTADORES_DELETED", "[]").subscribe();
			rkpt.send("cartelera-topic", "ESPECTADORES_DELETED", "[]").subscribe();
			rkpt.send("dashboard-topic", "ESPECTADORES_DELETED", "[]").subscribe();
			rkpt.send("espectador-topic", "ESPECTADORES_DELETED", "[]").subscribe();
			rkpt.send("funcion-topic", "ESPECTADORES_DELETED", "[]").subscribe();
			rkpt.send("pelicula-topic", "ESPECTADORES_DELETED", "[]").subscribe();
			rkpt.send("sala-topic", "ESPECTADORES_DELETED", "[]").subscribe();
		});
	}

}
