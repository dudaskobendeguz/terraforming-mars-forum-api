package com.codecool.terraformingmarsforum.model;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;


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
    Date timestamp;

    @Column(length = 50)
    String gameType;
    String name;

    @Column(length = 1000)
    String imageSource;
    int numberOfFinishedRounds;
    int numberOfRounds;

    @ManyToOne
    AppUser leagueAdmin;

    @ManyToMany
    @ToString.Exclude
    List<AppUser> players;


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
