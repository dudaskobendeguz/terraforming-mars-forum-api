package com.codecool.terraformingmarsforum.service;

import com.codecool.terraformingmarsforum.model.Comment;
import com.codecool.terraformingmarsforum.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public void createComment(Comment comment) {
        commentRepository.save(comment);
    }
}
