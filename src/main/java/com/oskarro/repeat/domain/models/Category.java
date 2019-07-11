package com.oskarro.repeat.domain.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document(collection = "categories")
public class Category {

    @Id
    String id;

    String name;


}
