package com.oskarro.repeat.domain.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document(collection = "users")
public class User {

    @Id
    String id;

    String identity;

    String name;

    Role role;
}
