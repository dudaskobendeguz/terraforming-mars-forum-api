package com.codecool.terraformingmarsforum.model;

import com.codecool.terraformingmarsforum.model.types.LeagueStatus;
import lombok.*;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * This class is the representation of a league post.
 * When new league detail information is coming from <a href="https://terraforming-mars-leagues.herokuapp.com/">terraforming Mars League</a>
 * , this object has created with the league post details.<br>
 * The Class {@link LeaguePost#description description} field contains the league 'status' information
 * i.e., "Zsu has Started 'Brutal League'".
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LeaguePost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    //TODO Generate description based on the current league status.
    String description;

    LeagueStatus leagueStatus;

    @ManyToOne
    LeagueDetail leagueDetail;

    int numberOfFinishedRounds;

    Date timeStamp;

    @OneToMany
    List<Comment> comments;
}
