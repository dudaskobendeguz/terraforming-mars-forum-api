package com.codecool.terraformingmarsforum.controller;


import com.codecool.terraformingmarsforum.service.LeagueDetailService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/league-detail")
public class LeagueDetailController {
    private final LeagueDetailService leagueDetailService;


    /**
     * Representation of the "player" of the {@link League leage}'s players,
     * who's are Users of the <a href="https://terraforming-mars-leagues.herokuapp.com/dashboard">Terraforming Mars League</a>
     */
    @Data
    private static class Player {
        @JsonProperty("id")
        Long id;

        @JsonProperty("email")
        String email;

        @JsonProperty("first_name")
        String firstName;

        @JsonProperty("last_name")
        String lastName;

        @JsonProperty("image_source")
        String imageSource;

        @JsonProperty("username")
        String username;
    }

    /**
     * Representation of the incoming League form <a href="https://terraforming-mars-leagues.herokuapp.com/dashboard">Terraforming Mars League</a>
     */
    @Data
    private static class League {
        @JsonProperty("id")
        Long id;

        @JsonProperty("game_type")
        String gameType;

        @JsonProperty("image_source")
        String imageSource;

        @JsonProperty("league_admin_id")
        Long leagueAdminId;

        @JsonProperty("league_players")
        List<Player> leaguePlayers;

        @JsonProperty("name")
        String name;

        @JsonProperty("number_of_finished_rounds")
        int numberOfFinishedRounds;

        @JsonProperty("number_of_in_progress_rounds")
        int numberOfInProgressRounds;

        @JsonProperty("number_of_rounds")
        int numberOfRounds;
    };

    //TODO do something with the incoming players(are they already users, or not?).
    /**
     * Save new {@link com.codecool.terraformingmarsforum.model.LeagueDetail LeagueDetail}
     * entity
     * @param league {@link League league} DTO
     */
//    @PostMapping("/new")
//    public void save(@RequestBody League league) {
//    LeagueDetail leagueDetail = LeagueDetail.builder()
//            .gameType(league.gameType)
//            .imageSource(league.imageSource)
//            .leagueId(league.id)
//            .leagueAdmin(league.leaguePlayers.stream().filter(player -> player.id.equals(league.id)).findFirst())
//            .build();
//    leaguePostService.save()
//    }
}



