package com.codecool.terraformingmarsforum.controller;


import com.codecool.terraformingmarsforum.service.LeagueDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/league-detail")
public class LeagueDetailController {
    private final LeagueDetailService leagueDetailService;

}
