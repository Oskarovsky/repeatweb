package com.oskarro.repeat.domain.service;

import com.oskarro.repeat.domain.repository.MealRepository;
import org.springframework.stereotype.Service;

@Service
public class MealService {

    private final MealRepository mealRepository;

    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }
}
