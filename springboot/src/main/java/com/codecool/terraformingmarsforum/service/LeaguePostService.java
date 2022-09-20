package com.codecool.terraformingmarsforum.service;

import com.codecool.terraformingmarsforum.model.Comment;
import com.codecool.terraformingmarsforum.model.LeagueDetail;
import com.codecool.terraformingmarsforum.model.LeaguePost;
import com.codecool.terraformingmarsforum.model.LeaguePostModel;
import com.codecool.terraformingmarsforum.repository.LeaguePostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class LeaguePostService {

    private final LeaguePostRepository leaguePostRepository;


    public LeaguePost save(LeaguePost leaguePost) {
        createDescription(leaguePost);
        return leaguePostRepository.save(leaguePost);
    }

    public List<LeaguePostModel> findAll() {
        List<LeaguePost> leaguePosts = leaguePostRepository.findAll();
        return leaguePosts.stream().map(this::createLeaguePostModel).toList();
    }

    //TODO description should be generated on frontend
    private void createDescription(LeaguePost leaguePost) {
        switch (leaguePost.getLeagueStatus()) {
            case STARTED -> leaguePost.setDescription(String.format(
                    "%s has started a %s %s league!",
                    leaguePost.getLeagueDetail().getLeagueAdmin().getUsername(),
                    leaguePost.getLeagueDetail().getGameType(),
                    leaguePost.getLeagueDetail().getName()
            ));

            case ROUND_IN_PROGRESS -> leaguePost.setDescription(String.format(
                    "Round %d started!",
                    (leaguePost.getNumberOfFinishedRounds() + 1)
            ));

            case ROUND_FINISHED -> leaguePost.setDescription(String.format(
                    "Round %d/%d finished",
                    leaguePost.getNumberOfFinishedRounds(),
                    leaguePost.getLeagueDetail().getNumberOfRounds()
            ));

            case FINISHED -> leaguePost.setDescription(String.format(
                    "The %s %s league has finished!",
                    leaguePost.getLeagueDetail().getGameType(),
                    leaguePost.getLeagueDetail().getName()
            ));
            default -> throw new IllegalArgumentException("No description for the given LeagueStatus");
        }
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

    public void addCommentToPostByPostId(Long postId, Comment comment) {
        LeaguePost leaguePost = leaguePostRepository.findById(postId).orElseThrow(() ->
                new NoSuchElementException("League post not found with id: '%d'!".formatted(postId))
        );
        leaguePost.getComments().add(comment);
        leaguePostRepository.save(leaguePost);
    }
}
