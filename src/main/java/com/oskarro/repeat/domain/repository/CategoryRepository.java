package com.oskarro.repeat.domain.repository;

import com.oskarro.repeat.domain.models.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CategoryRepository extends ReactiveMongoRepository<Category, String> {

}
