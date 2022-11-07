package com.training.reactive.service.impl;

import com.training.reactive.documents.Client;
import com.training.reactive.repository.ClientRespository;
import com.training.reactive.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private ClientRespository clientRespository;

    @Override
    public Flux<Client> findAllClient() {
        return clientRespository.findAll();
    }

    @Override
    public Mono<Client> findById(String id) {
        return clientRespository.findById(id);
    }

    @Override
    public Mono<Client> save(Client client) {
        return clientRespository.save(client);
    }

    @Override
    public Mono<Void> delete(String id) {
        return clientRespository.deleteById(id);
    }
}
