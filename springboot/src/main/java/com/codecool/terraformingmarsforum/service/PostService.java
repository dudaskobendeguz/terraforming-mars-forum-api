package com.codecool.terraformingmarsforum.service;

import com.codecool.terraformingmarsforum.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final UserPostService userPostService;
    private final LeaguePostService leaguePostService;

    public List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>();
        posts.addAll(userPostService.getAllUserPosts());
        posts.addAll(leaguePostService.findAll());
        return posts;
    }
}
