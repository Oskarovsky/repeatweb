package com.oskarro.repeat.domain.service;

import com.oskarro.repeat.domain.models.User;
import com.oskarro.repeat.domain.repository.UserRepository;
import com.oskarro.repeat.domain.vo.UserRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<User> update(String id, UserRequest userRequest) {
        return this.userRepository.findById(id).flatMap(user -> {
            user.setIdentity(userRequest.getIdentity());
            user.setName(userRequest.getIdentity());
            user.setRole(userRequest.getRole());
            return this.userRepository.save(user);
        });
    }

    public Mono<User> create(UserRequest userRequest) {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setIdentity(userRequest.getIdentity());
        user.setName(userRequest.getName());
        user.setRole(userRequest.getRole());
        return this.userRepository.save(user);
    }

    public void delete(String id) {
        this.userRepository.deleteById(id);
    }

    public Flux<User> findAll() {
        return this.userRepository.findAll();
    }

    public Mono<User> findOne(String id) {
        return this.userRepository.findById(id);
    }
}
