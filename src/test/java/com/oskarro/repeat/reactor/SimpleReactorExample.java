package com.oskarro.repeat.reactor;

import com.oskarro.repeat.domain.models.Category;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.UnicastProcessor;

import java.util.UUID;

public class SimpleReactorExample {

    @Test
    public void coldBehavior() {
        Category polish = new Category();
        polish.setName("polish");
        Category greece = new Category();
        polish.setName("greece");
        Flux.just(polish, greece)
                .doOnNext(System.out::println);
    }

    @Test
    public void coldBehaviorWithSubscribe() {
        Category polish = new Category();
        polish.setId(UUID.randomUUID().toString());
        polish.setName("polish");
        Category greece = new Category();
        greece.setId(UUID.randomUUID().toString());
        greece.setName("greece");
        Flux.just(polish, greece)
                .doOnNext(System.out::println)
                .subscribe();
    }

    @Test
    public void testHotPublisher() {
        UnicastProcessor<String> hotSource = UnicastProcessor.create();
        Flux<Category> hotPublisher = hotSource
                .publish()
                .autoConnect()
                .map((String t) -> Category.builder().name(t).build());
        hotPublisher.subscribe(category -> System.out.println("Subscriber 1: " + category.getName()));
        hotSource.onNext("polish");
        hotSource.onNext("greece");
        hotPublisher.subscribe(category -> System.out.println("Subscriber 2:" + category.getName()));
        hotSource.onNext("mediterranean");
        hotSource.onNext("balkan");
        hotSource.onComplete();
    }
}
