package com.oskarro.repeat.domain.models;

import lombok.Data;

import java.util.Set;

@Data
public class Meal {

    String id;
    String title;
    String content;
    User author;

    Set<User> mandatoryReviewers;
    Set<Opinion> reviewers;
    Set<Category> categories;
    Set<Tag> tags;

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
