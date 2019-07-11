package com.oskarro.repeat.domain.repository;

import com.oskarro.repeat.domain.models.Meal;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MealRepository extends ReactiveMongoRepository<Meal, String> {
}
