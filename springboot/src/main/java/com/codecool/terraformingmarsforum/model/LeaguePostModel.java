package com.codecool.terraformingmarsforum.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;


/**
 * This class is the representation of the application's frontend information
 * about a <a href="http://localhost:4200/league-posts">league post</a>.
 */
@Data
@Builder
@AllArgsConstructor
public class LeaguePostModel {
    Long leagueId;
    //TODO This description field is not used yet. implement it in frontend first.
    String description;
    Timestamp timestamp;
    String gameType;
    String name;
    AppUser leagueAdmin;
    int numberOfPlayers;
    int numberOfRounds;
    int numberOfComments;
    String imageSource;
}
