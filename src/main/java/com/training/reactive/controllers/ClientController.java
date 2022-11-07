package com.training.reactive.controllers;

import com.training.reactive.documents.Client;
import com.training.reactive.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/client")
@AllArgsConstructor
public class ClientController {

    private ClientService clientService;


    @PostMapping("/save")
    public Mono<ResponseEntity<Client>> save(@RequestBody Client client) {
        return clientService.save(client).map(c -> ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(c)
        ).defaultIfEmpty(ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }


    @GetMapping("/findAll")
    public Mono<ResponseEntity<Flux<Client>>> findAll() {
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(clientService.findAllClient())
        );

    }

    @GetMapping("/find/{id}")
    public Mono<ResponseEntity<Client>> findById(@PathVariable String id) {
        return clientService.findById(id).map(c -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(c))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
