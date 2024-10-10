package com.sebxama.consumer.boot;

import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.sail.SailRepository;
import org.eclipse.rdf4j.sail.memory.MemoryStore;
import org.eclipse.rdf4j.spring.RDF4JConfig;
import org.eclipse.rdf4j.spring.support.RDF4JTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(RDF4JConfig.class)
public class RDF4JConfiguration {
	
	@Bean
	public Repository getRepository() {
		Repository repo = new SailRepository(new MemoryStore());
		return repo;
	}

}
