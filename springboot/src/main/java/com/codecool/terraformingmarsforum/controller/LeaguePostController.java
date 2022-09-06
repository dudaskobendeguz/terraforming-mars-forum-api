package com.codecool.terraformingmarsforum.controller;


import com.codecool.terraformingmarsforum.service.LeaguePostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class LeaguePostController {
    private final LeaguePostService leaguePostService;
}
