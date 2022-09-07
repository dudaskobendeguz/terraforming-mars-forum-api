package com.codecool.terraformingmarsforum.controller;


import com.codecool.terraformingmarsforum.model.LeaguePostModel;
import com.codecool.terraformingmarsforum.service.LeaguePostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/league-posts")
public class LeaguePostController {
    private final LeaguePostService leaguePostService;

    @GetMapping
    public ResponseEntity<List<LeaguePostModel>> getAll() {
        return ResponseEntity.ok().body(leaguePostService.findAll());
    }

}
