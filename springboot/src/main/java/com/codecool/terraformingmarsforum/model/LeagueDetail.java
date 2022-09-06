package com.codecool.terraformingmarsforum.model;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class LeagueDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long leagueId;
    Timestamp timestamp;
    @Column(length = 50)
    String gameType;
    String name;
    String imageSource;
    String numberOfFinishedRounds;
    String numberOfRounds;

    @ManyToOne
    AppUser leagueAdmin;

    @ManyToMany
    @ToString.Exclude
    Set<AppUser> players;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LeagueDetail that = (LeagueDetail) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
