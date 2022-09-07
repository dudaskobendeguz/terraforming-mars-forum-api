package com.codecool.terraformingmarsforum.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;


/**
 * This class is the representation of the application's frontend information
 * about a <a href="http://localhost:4200/league-posts">league post</a>.
 */
@Data
@Builder
@AllArgsConstructor
public class LeaguePostModel {
    Long leagueId;
    String description;
    Date timestamp;
    String gameType;
    String name;
    AppUser leagueAdmin;
    int numberOfPlayers;
    int numberOfRounds;
    int numberOfComments;
    String imageSource;
}
