package com.codecool.terraformingmarsforum.service;

import com.codecool.terraformingmarsforum.model.Comment;
import com.codecool.terraformingmarsforum.model.types.PostType;
import com.codecool.terraformingmarsforum.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    /**
     * Saves comment to database
     * @param   comment Comment
     * @param   postType PostType
     * @param   postId Long*/
    public Comment createComment(Comment comment, PostType postType, Long postId) {
        return commentRepository.save(comment);
    }
}
