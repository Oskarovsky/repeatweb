package com.oskarro.repeat.domain.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "meal")
public class Meal {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    String id;

    String title;

    String content;

    @ManyToOne
    User author;

    @OneToMany
    Set<User> mandatoryReviewers = new HashSet<>();

    @ElementCollection
    Set<Opinion> reviewers = new HashSet<>();

    @OneToMany
    Set<Category> categories = new HashSet<>();

    @ElementCollection
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
