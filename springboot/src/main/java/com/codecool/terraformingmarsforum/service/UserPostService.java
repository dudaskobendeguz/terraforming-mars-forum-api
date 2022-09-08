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
        Optional<UserPost> post = userPostRepository.findById(postId);
        post.map(p -> p.getComments().add(comment)).orElseThrow(NoSuchElementException::new);
        userPostRepository.save(post.get());
    }
}
