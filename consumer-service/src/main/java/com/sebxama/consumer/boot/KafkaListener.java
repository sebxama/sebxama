package com.sebxama.consumer.boot;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.kafka.receiver.ReceiverRecord;

@Configuration
public class KafkaListener {

	@Autowired
	ReactiveKafkaConsumerTemplate<String, String> receiverTemplate;

	@Autowired
	ReactiveKafkaProducerTemplate<String, String> producerTemplate;

	@Autowired
	WebClient.Builder wcBuilder;

	@Autowired
//	FuncionService funcionService;
	
    @EventListener(ApplicationStartedEvent.class)
    public Disposable startKafkaConsumer() {
        return receiverTemplate.receiveAutoAck()
        // .delayElements(Duration.ofSeconds(2L)) // BACKPRESSURE
        .doOnNext(consumerRecord -> 
        	System.out.println("received key={"+consumerRecord.key()+"}, value={"+consumerRecord.value()+"} from topic={"+consumerRecord.topic()+"}, offset={"+consumerRecord.offset()+"}"))
        .map(consumerRecord -> this.handleEvent(consumerRecord.key(), consumerRecord.value()))
        .doOnNext(dto -> System.out.println("successfully consumed {"+dto.getClass().getSimpleName()+"}={"+dto+"}"))
        .doOnError(throwable -> System.out.println("error: {"+throwable.getMessage()+"}"))
        .subscribe();
    }

//    private Mono<String> handleEvent(String key, String record) {
//    	// Services business layer handling
//    	System.out.println("handleEvent; KEY: "+key+"; RECORD: "+record);
//		if(key.equalsIgnoreCase("FUNCION_STARTED"))
//			handleFuncionStarted(record);
//    	return Mono.just(record);
//    }

//	private void handleFuncionStarted(String record) {
//
//		try {
//
//			System.out.println("handleFuncionStarted: "+record);
//			ObjectMapper mapper = new ObjectMapper();
//			mapper.registerModule(new JavaTimeModule());
//			
//			JsonNode ticket = mapper.readTree(record);
//			int idFuncion = ticket.get("id").asInt();
//			System.out.println("idFuncion: "+idFuncion);
//
//			System.out.println("Listening, idFuncion:"+idFuncion);
//			
//			Flux<Ticket> tickets = this.ticketService.findByIdFuncion(idFuncion);
//			tickets.flatMap(tic -> {
//				tic.setEstado(TicketEstado.CONSUMIDO);
//				this.ticketService.update(tic.getId(), tic).subscribe();
//				return Mono.just(tic);
//			}).subscribe();
//
//		} catch(Throwable t) {
//			t.printStackTrace();
//		}
//	}

	private Mono<String> handleEvent(String key, String record) {
		System.out.println("handleEvent: KEY: "+key+", RECORD: "+record);
//		if(key.equalsIgnoreCase("TICKET_CREATED"))
//			handleTicketCreated(record);
//		if(key.equalsIgnoreCase("TICKET_DELETED"))
//			handleTicketDeleted(record);
//		if(key.equalsIgnoreCase("TICKETS_DELETED"))
//			handleTicketsDeleted(record);
		return Mono.just(record);
	}

//	private void handleTicketCreated(String record) {
//
//		try {
//
//			System.out.println("handleTicketCreated: "+record);
//			ObjectMapper mapper = new ObjectMapper();
//			JsonNode ticket = mapper.readTree(record);
//			int idFuncion = ticket.get("idFuncion").asInt();
//			int idTicket = ticket.get("id").asInt();
//			System.out.println("idFuncion: "+idFuncion);
//			System.out.println("idTicket: "+idTicket);
//
//			wcBuilder
//			.build()
//			.get()
//			.uri("http://funcion-service/funcion-service/api/funcion/"+idFuncion)
//			.retrieve()
//			.bodyToMono(Funcion.class)
//			.<Funcion>flatMap(fun -> {			
//				wcBuilder
//				.build()
//				.get()
//				.uri("http://sala-service/sala-service/api/sala/"+fun.getIdSala())
//				.retrieve()
//				.bodyToMono(Sala.class)
//				.<Sala>flatMap(sala -> {
//					int ticketsSold = fun.getTicketsSold();
//					int capacidad = sala.getCapacidad();
//					System.out.println("ticketsSold: "+ticketsSold);
//					System.out.println("capacidad: "+capacidad);
//					if(ticketsSold +1 <= capacidad) {
//						fun.setTicketsSold(fun.getTicketsSold()+1);
//						funcionService.update(fun.getId(), fun).subscribe();
//					}
//					return Mono.just(sala);
//				}).subscribe();
//				return Mono.just(fun);
//			}).subscribe();
//
//		} catch(Throwable t) {
//			t.printStackTrace();
//		}
//	}
//
//	private void handleTicketDeleted(String record) {
//		try {
//
//			System.out.println("handleTicketDeleted: "+record);
//			ObjectMapper mapper = new ObjectMapper();
//			JsonNode ticket = mapper.readTree(record);
//			//int idTicket = ticket.get("id").asInt();
//			int idFuncion = ticket.get("idFuncion").asInt();
//
//			wcBuilder
//			.build()
//			.get()
//			.uri("http://funcion-service/funcion-service/api/funcion/"+idFuncion)
//			.retrieve()
//			.bodyToMono(Funcion.class)
//			.<Funcion>map(fun -> {
//				System.out.println("Function map...");
//				if(fun.getTicketsSold() -1 >= 0) {
//					fun.setTicketsSold(fun.getTicketsSold() -1);
//					funcionService.update(fun.getId(), fun).subscribe();
//				}
//				return fun;
//			}).subscribe();
//
//		} catch(Throwable t) {
//			t.printStackTrace();
//		}
//	}
//
//	private void handleTicketsDeleted(String record) {
//		try {
//
//			System.out.println("handleTicketDeleted: "+record);
//
//			wcBuilder
//			.build()
//			.get()
//			.uri("http://funcion-service/funcion-service/api/funcion/")
//			.retrieve()
//			.<Funcion>bodyToFlux(Funcion.class)
//			.<Funcion>flatMap(fun -> {
//				System.out.println("Function map...");
//				fun.setTicketsSold(0);
//				return funcionService.update(fun.getId(), fun);
//			}).subscribe();
//
//		} catch(Throwable t) {
//			t.printStackTrace();
//		}
//	}
	
}
