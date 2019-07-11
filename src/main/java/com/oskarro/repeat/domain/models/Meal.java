package com.oskarro.repeat.domain.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Data
@Document(collection = "meals")
public class Meal {

    @Id
    String id;

    String title;

    String content;

    User author;

    Set<User> mandatoryReviewers = new HashSet<>();

    Set<Opinion> reviewers = new HashSet<>();

    Set<Category> categories = new HashSet<>();

    Set<Tag> tags = new HashSet<>();

    public Opinion opinion(String userId, String status) {
        final Opinion opinion = new Opinion(userId, status);
        this.reviewers.add(opinion);
        return opinion;
    }

    public Boolean revised() {
        return this.mandatoryReviewers
                .stream()
                .allMatch(reviewer -> this.reviewers
                        .stream()
                        .anyMatch(review -> reviewer.id.equals(review.userId) && "approved".equals(review.status)));
    }
}
