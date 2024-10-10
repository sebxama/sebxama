package com.sebxama.datasource.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.sebxama.datasource.model.Datasource;

import reactor.core.publisher.Flux;

@Repository
public interface DatasourceRepository extends R2dbcRepository<Datasource, Integer> {

	Flux<Datasource> findByNameContaining(String nombre);

}
