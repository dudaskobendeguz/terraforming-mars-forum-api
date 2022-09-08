package com.codecool.terraformingmarsforum.controller;


import com.codecool.terraformingmarsforum.model.AppUser;
import com.codecool.terraformingmarsforum.model.LeagueDetail;
import com.codecool.terraformingmarsforum.service.LeagueDetailService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/league-detail")
public class LeagueDetailController {
    private final LeagueDetailService leagueDetailService;


    /**
     * Representation of the {@link League leage}'s players,
     * who's are Users of the
     * <a href="https://terraforming-mars-leagues.herokuapp.com/dashboard">Terraforming Mars League</a>
     */
    @Data
    private static class Player {
        /**
         * The id of the
         * <a href="https://terraforming-mars-leagues.herokuapp.com/dashboard">Terraforming Mars League's</a> user
         */
        @NonNull
        @JsonProperty("id")
        Long id;

        @NonNull
        @JsonProperty("email")
        String email;

        @NonNull
        @JsonProperty("first_name")
        String firstName;

        @NonNull
        @JsonProperty("last_name")
        String lastName;

        @NonNull
        @JsonProperty("image_source")
        String imageSource;

        @NonNull
        @JsonProperty("username")
        String username;

        /**
         * Create the representation of the
         *  <a href="https://terraforming-mars-leagues.herokuapp.com/dashboard">Terraforming Mars League's</a> player.
         * @return not persisted {@link AppUser AppUser}
         */
        public AppUser createAppUser() {
            return AppUser.builder()
                    .email(email)
                    .firstName(firstName)
                    .lastName(lastName)
                    .imageSource(imageSource)
                    .username(username)
                    .build();
        }
    }

    /**
     * Representation of the incoming League form
     * <a href="https://terraforming-mars-leagues.herokuapp.com/dashboard">Terraforming Mars League</a>
     */
    @Data
    private static class League {
        /**
         * The id of the <a href="https://terraforming-mars-leagues.herokuapp.com/dashboard">Terraforming Mars League's</a> league
         */
        @NonNull
        Long id;

        @JsonProperty("game_type")
        @NonNull
        String gameType;

        @JsonProperty("image_source")
        @NonNull
        String imageSource;

        @JsonProperty("league_admin_id")
        @NonNull
        Long leagueAdminId;

        @JsonProperty("league_players")
        @NonNull
        List<Player> leaguePlayers;

        @NonNull
        String name;

        @JsonProperty("number_of_finished_rounds")
        @NonNull
        Integer numberOfFinishedRounds;

        @JsonProperty("number_of_in_progress_rounds")
        @NonNull
        Integer numberOfInProgressRounds;

        @JsonProperty("number_of_rounds")
        @NonNull
        Integer numberOfRounds;

        /**
         * Create the representation of the
         *  <a href="https://terraforming-mars-leagues.herokuapp.com/dashboard">Terraforming Mars League's</a> League.
         * @return not persisted {@link LeagueDetail LeagueDetail}
         */
        public LeagueDetail createLeagueDetail() {
            return LeagueDetail.builder()
                    .name(name)
                    .imageSource(imageSource)
                    .numberOfRounds(numberOfRounds)
                    .leagueAdmin(leaguePlayers.stream()
                            .filter(player -> player.id.equals(leagueAdminId))
                            .findFirst()
                            .orElseThrow(() -> new NoSuchElementException("League admin not found!"))
                            .createAppUser())
                    .leagueId(id)
                    .gameType(gameType)
                    .build();
        }

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



