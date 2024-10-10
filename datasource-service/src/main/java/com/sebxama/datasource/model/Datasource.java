package com.sebxama.datasource.model;

import com.sebxama.functional.model.Statement;

import reactor.core.publisher.Flux;

public abstract class Datasource {

	public abstract String getName();
	
	public abstract Flux<Statement> consume();
	
	public abstract void produce(Flux<Statement> stream);
	
}
