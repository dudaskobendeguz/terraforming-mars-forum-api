package com.codecool.terraformingmarsforum.service;


import com.codecool.terraformingmarsforum.model.LeagueDetail;
import com.codecool.terraformingmarsforum.repository.LeagueDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LeagueDetailService {
    private final LeagueDetailRepository leagueDetailRepository;

    public LeagueDetail save(LeagueDetail leagueDetail) {
        return leagueDetailRepository.save(leagueDetail);
    }
}
