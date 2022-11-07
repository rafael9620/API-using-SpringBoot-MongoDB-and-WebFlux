package com.training.reactive.service;

import com.training.reactive.documents.Client;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface ClientService {
    Flux<Client> findAllClient();

    Mono<Client> findById(String id);

    Mono<Client> save(Client client);

    Mono<Void>  delete(String id);

}

