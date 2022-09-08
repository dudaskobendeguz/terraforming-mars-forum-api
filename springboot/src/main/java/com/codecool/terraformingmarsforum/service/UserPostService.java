package com.codecool.terraformingmarsforum.service;

import com.codecool.terraformingmarsforum.model.Comment;
import com.codecool.terraformingmarsforum.model.UserPost;
import com.codecool.terraformingmarsforum.repository.UserPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserPostService {

    private final UserPostRepository userPostRepository;

    public List<UserPost> getAllUserPosts() {
        return userPostRepository.findAll();
    }

    public void addCommentToPostByPostId(Long postId, Comment comment){
        UserPost userPost = userPostRepository.findById(postId).orElseThrow(NoSuchElementException::new);
        userPost.getComments().add(comment);
        userPostRepository.save(userPost);
    }
}
