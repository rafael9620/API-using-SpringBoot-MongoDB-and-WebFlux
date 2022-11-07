package com.training.reactive.repository;

import com.training.reactive.documents.Client;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ClientRespository extends ReactiveMongoRepository<Client, String> {
}
