package com.codecool.terraformingmarsforum.service;

import com.codecool.terraformingmarsforum.model.Comment;
import com.codecool.terraformingmarsforum.model.UserPost;
import com.codecool.terraformingmarsforum.repository.AppUserRepository;
import com.codecool.terraformingmarsforum.repository.UserPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserPostService {

    private final UserPostRepository userPostRepository;
    private final AppUserRepository appUserRepository;

    public List<UserPost> getAllUserPosts() {
        return userPostRepository.findAll();
    }

    public UserPost createUserPost(UserPost userPost) {
        Long userId = userPost.getUser().getId();
        userPost.setUser(appUserRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("User: %d not found".formatted(userId))
        ));
        userPost.setTimestamp(new Date());
        return userPostRepository.save(userPost);
    }

    public void addCommentToPostByPostId(Long postId, Comment comment) {
        UserPost userPost = userPostRepository.findById(postId).orElseThrow(NoSuchElementException::new);
        userPost.getComments().add(comment);
        userPostRepository.save(userPost);
    }
}
