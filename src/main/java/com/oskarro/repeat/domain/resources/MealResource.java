package com.oskarro.repeat.domain.resources;

import com.oskarro.repeat.domain.models.Meal;
import com.oskarro.repeat.domain.models.Opinion;
import com.oskarro.repeat.domain.vo.MealRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/meal")
public class MealResource {

    @GetMapping(value = "/{id}")
    public ResponseEntity<Meal> findOne(@PathVariable("id") String id) {
        return ResponseEntity.ok(new Meal());
    }

    @GetMapping
    public ResponseEntity<List<Meal>> findAll() {
        return ResponseEntity.ok(Arrays.asList(new Meal(), new Meal()));
    }

    @PostMapping
    public ResponseEntity<Meal> newMeal(MealRequest meal) {
        return new ResponseEntity<>(new Meal(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeMeal(@PathVariable("id") String id) { }

    @PutMapping("/{id}")
    public ResponseEntity<Meal> updateMeal(@PathVariable("id") String id,
                                           MealRequest meal) {
        return new ResponseEntity<>(new Meal(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/opinion/{userId}")
    public ResponseEntity<Opinion> opinion(@PathVariable("id") String id,
                                           @PathVariable("userId") String userId) {
        return ResponseEntity.ok(new Opinion());
    }

    @GetMapping(value = "/opinioned")
    public ResponseEntity<List<Meal>> opinionedMeal() {
        return ResponseEntity.ok(Arrays.asList(new Meal(), new Meal()));
    }
}
