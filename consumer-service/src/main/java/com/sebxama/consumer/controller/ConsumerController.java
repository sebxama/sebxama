package com.sebxama.consumer.controller;

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
import com.sebxama.consumer.model.Espectador;
import com.sebxama.consumer.service.ConsumerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/espectador-service/api")
public class ConsumerController {

	@Autowired
	ConsumerService espectadorService;
	
	@GetMapping("/ping")
	@ResponseStatus(HttpStatus.OK)
	public Mono<String> ping() {
		Espectador e = new Espectador();
		e.setNombre("Ed");
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(e);
			mapper.readValue(json, Espectador.class);
		} catch(Throwable ex) {
			ex.printStackTrace();
			return Mono.just(ex.getMessage());
		}
		return Mono.just(json);
	}

//	@PostMapping("/onEspectador")
//	@ResponseStatus(HttpStatus.ACCEPTED)
//	public Mono<Espectador> onEspectador(@RequestBody Espectador espectador){
//		System.out.println("CinemaController::onEspectador");
//		return espectadorService.onEspectador(espectador);
//	}
	
	@GetMapping("/espectador")
	@ResponseStatus(HttpStatus.OK)
	public Flux<Espectador> getAll() {
		return espectadorService.findAll();
	}

	@GetMapping("/espectador/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Mono<Espectador> getEspectadorById(@PathVariable("id") int id) {
		return espectadorService.findById(id);
	}

	@GetMapping("/espectador/byNombre")
	@ResponseStatus(HttpStatus.OK)
	public Flux<Espectador> getEspectadoresByNombre(@RequestParam("nombre") String nombre) {
		return espectadorService.findByNombreContaining(nombre);
	}
	
	@PostMapping("/espectador")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Espectador> createEspectador(@RequestBody Espectador e) {
		Espectador f = new Espectador();
		f.setNombre(e.getNombre());
		f.setEstado(e.getEstado());
		return espectadorService.save(f);
	}

	@PutMapping("/espectador/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Mono<Espectador> updateEspectador(@PathVariable("id") int id, @RequestBody Espectador espectador) {
		return espectadorService.update(id, espectador);
	}
	
	@DeleteMapping("/espectador/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Mono<Void> deleteEspectador(@PathVariable("id") int id) {
		return espectadorService.deleteById(id);
	}

	@DeleteMapping("/espectador")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Mono<Void> deleteAllEspectadores() {
		return espectadorService.deleteAll();
	}

}
