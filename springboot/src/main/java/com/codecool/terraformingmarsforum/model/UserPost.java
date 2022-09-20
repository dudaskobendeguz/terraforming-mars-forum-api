
package com.codecool.terraformingmarsforum.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Entity object representing a post created by the user.
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserPost implements Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    @ManyToOne
    private AppUser user;

    private String description;

    @OneToMany
    @ToString.Exclude
    @Builder.Default
    private List<Comment> comments = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserPost userPost = (UserPost) o;
        return id != null && Objects.equals(id, userPost.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
