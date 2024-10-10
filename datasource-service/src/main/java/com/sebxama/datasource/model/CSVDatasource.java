package com.sebxama.datasource.model;

import com.sebxama.functional.model.Statement;

import reactor.core.publisher.Flux;

public class CSVDatasource extends Datasource {

	@Override
	public Flux<Statement> consume() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void produce(Flux<Statement> stream) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
