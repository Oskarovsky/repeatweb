package com.oskarro.repeat.domain.resources;

import com.oskarro.repeat.domain.models.Category;
import com.oskarro.repeat.domain.service.CategoryService;
import com.oskarro.repeat.domain.vo.CategoryRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/category")
public class CategoryResource {

    private final CategoryService categoryService;

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Mono<Category>> findOne(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.categoryService.findOne(id));
    }

    @GetMapping
    public ResponseEntity<Flux<Category>> findAll() {
        return ResponseEntity.ok(this.categoryService.findAll());
    }

    @PostMapping
    public ResponseEntity<Mono<Category>> newCategory(@RequestBody CategoryRequest category) {
        return new ResponseEntity<>(this.categoryService.create(category), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCategory(@PathVariable("id") String id) {
        this.categoryService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Mono<Category>> updateCategory(@PathVariable("id") String id,
                                                   CategoryRequest category) {
        return new ResponseEntity<>(this.categoryService.update(id, category), HttpStatus.OK);
    }
}
