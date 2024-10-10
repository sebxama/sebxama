package com.sebxama.datasource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sebxama.datasource.model.Datasource;
import com.sebxama.datasource.service.DatasourceService;
import com.sebxama.functional.model.dto.Quad;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/datasource")
public class DatasourceController {

	@Autowired
	DatasourceService datasourceService;
	
	@GetMapping("/ping")
	@ResponseStatus(HttpStatus.OK)
	public Mono<String> ping() {
		return Mono.just("OK!");
	}

	@GetMapping("/testQuads")
	@ResponseStatus(HttpStatus.OK)
	public Mono<String> testQuads() {
		Quad quad1 = new Quad("http://example.org/statement", "http://example.org/context", "http://example.org/subject", "http://example.org/predicate", "http://example.org/object");
		datasourceService.publishQuad("augmentation-topic", quad1);
		return Mono.just("OK!");
	}

}
