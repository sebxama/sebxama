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

package com.sebxama.augmentation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sebxama.augmentation.service.AugmentationService;
import com.sebxama.functional.model.Statement;
import com.sebxama.functional.model.dto.Quad;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/augmentation")
public class AugmentationController {

	@Autowired
	AugmentationService augmentationService;
	
	@GetMapping("/ping")
	@ResponseStatus(HttpStatus.OK)
	public Mono<String> ping() {
		return Mono.just("OK");
	}

	@PostMapping("/perform")
	@ResponseBody
	public Mono<Quad> perform(@RequestBody Quad quad) {
		return augmentationService.perform(quad);
	}
	
	@GetMapping("/testQuads")
	@ResponseStatus(HttpStatus.OK)
	public Mono<Quad> testQuads() {
		Quad quad1 = new Quad("http://example.org/statement", "http://example.org/context", "http://example.org/subject", "http://example.org/predicate", "http://example.org/object");
		return augmentationService.perform(quad1);
	}

}
