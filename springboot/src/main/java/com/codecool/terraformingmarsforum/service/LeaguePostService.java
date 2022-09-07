package com.codecool.terraformingmarsforum.service;

import com.codecool.terraformingmarsforum.model.LeagueDetail;
import com.codecool.terraformingmarsforum.model.LeaguePost;
import com.codecool.terraformingmarsforum.model.LeaguePostModel;
import com.codecool.terraformingmarsforum.repository.LeaguePostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class LeaguePostService {

    private final LeaguePostRepository leaguePostRepository;

    public List<LeaguePostModel> findAll() {
        List<LeaguePost> leaguePosts = leaguePostRepository.findAll();
        return leaguePosts.stream().map(this::createLeaguePostModel).toList();
    }

    private LeaguePostModel createLeaguePostModel(LeaguePost leaguePost) {
        LeagueDetail leagueDetail = leaguePost.getLeagueDetail();
        return LeaguePostModel.builder()
                .leagueId(leagueDetail.getLeagueId())
                .leagueAdmin(leagueDetail.getLeagueAdmin())
                .gameType(leagueDetail.getGameType())
                .name(leagueDetail.getName())
                .description(leaguePost.getDescription())
                .timestamp(leagueDetail.getTimestamp())
                .imageSource(leagueDetail.getImageSource())
                .numberOfComments(leaguePost.getComments().size())
                .numberOfPlayers(leagueDetail.getPlayers().size())
                .numberOfRounds(leagueDetail.getNumberOfRounds())
                .build();
    }
}
