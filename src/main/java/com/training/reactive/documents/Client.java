package com.training.reactive.documents;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Document(collation = "clients")
@Data
public class Client {
    @Id
    private String id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String lastName;
    @NotNull
    private String emial;
    @NotNull
    private String age;
    @NotNull
    private String salary;

    public Client() {
    }
}
