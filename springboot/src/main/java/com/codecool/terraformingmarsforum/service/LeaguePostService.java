package com.codecool.terraformingmarsforum.service;

import com.codecool.terraformingmarsforum.repository.LeaguePostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class LeaguePostService {

    private final LeaguePostRepository leaguePostRepository;
}
