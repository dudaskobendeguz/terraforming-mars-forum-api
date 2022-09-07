package com.codecool.terraformingmarsforum.model;

import com.codecool.terraformingmarsforum.model.types.LeagueStatus;
import lombok.*;

import javax.annotation.PostConstruct;
import javax.persistence.*;
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

    @OneToMany
    List<Comment> comments;

    @PostConstruct
    private void createDescription() {
        switch (leagueStatus) {
            case STARTED ->
                description = String.format(
                        "%s has started a %s %s league!",
                        leagueDetail.getLeagueAdmin().getUsername(),
                        leagueDetail.gameType,
                        leagueDetail.name
                );

            case ROUND_IN_PROGRESS ->
                description = String.format(
                        "Round %d started!",
                        (leagueDetail.numberOfFinishedRounds + 1)
                );

            case ROUND_FINISHED ->
                description = String.format(
                        "Round %d/%d finished",
                        leagueDetail.numberOfFinishedRounds,
                        leagueDetail.numberOfRounds
                );

            case FINISHED ->
                description = String.format(
                        "The %s %s league has finished!",
                        leagueDetail.gameType,
                        leagueDetail.name
                );
            default -> throw new IllegalArgumentException("No description for the given LeagueStatus");
        }
    }
}
