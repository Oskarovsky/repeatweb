package com.oskarro.repeat.domain.resources;

import com.oskarro.repeat.domain.models.User;
import com.oskarro.repeat.domain.vo.UserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserResource {

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findOne(@PathVariable("id") String id) {
        return ResponseEntity.ok(new User());
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(Arrays.asList(new User(), new User()));
    }

    @PostMapping
    public ResponseEntity<User> newUser(UserRequest user) {
        return new ResponseEntity<>(new User(), HttpStatus.OK);
    }

    @DeleteMapping("/id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeUser(@PathVariable("id") String id){
    }

    @PutMapping("/id")
    public ResponseEntity<User> updateUser(@PathVariable("id") String id,
                                           UserRequest user) {
        return new ResponseEntity<>(new User(), HttpStatus.OK);
    }
}
