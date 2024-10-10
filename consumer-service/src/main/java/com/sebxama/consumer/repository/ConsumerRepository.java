package com.sebxama.consumer.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.sebxama.consumer.model.Espectador;

import reactor.core.publisher.Flux;

@Repository
public interface ConsumerRepository extends R2dbcRepository<Espectador, Integer> {

	Flux<Espectador> findByNombreContaining(String nombre);

}
