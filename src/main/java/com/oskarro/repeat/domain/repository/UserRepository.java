package com.oskarro.repeat.domain.repository;

import com.oskarro.repeat.domain.models.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
