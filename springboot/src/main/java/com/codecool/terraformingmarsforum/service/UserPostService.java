package com.codecool.terraformingmarsforum.service;

import com.codecool.terraformingmarsforum.model.UserPost;
import com.codecool.terraformingmarsforum.repository.UserPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserPostService {

    private final UserPostRepository userPostRepository;

    public List<UserPost> getAllUserPosts() {
        return userPostRepository.findAll();
    }
}
