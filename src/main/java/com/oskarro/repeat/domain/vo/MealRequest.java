package com.oskarro.repeat.domain.vo;

import com.oskarro.repeat.domain.models.Category;
import com.oskarro.repeat.domain.models.Tag;
import lombok.Data;

import java.util.Set;

@Data
public class MealRequest {

    String title;
    String content;
    Set<Category> categories;
    Set<Tag> tags;
}
