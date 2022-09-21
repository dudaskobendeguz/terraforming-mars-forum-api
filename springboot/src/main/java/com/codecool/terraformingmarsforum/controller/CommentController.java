package com.codecool.terraformingmarsforum.controller;

import com.codecool.terraformingmarsforum.dto.CommentCreationDTO;
import com.codecool.terraformingmarsforum.model.Comment;
import com.codecool.terraformingmarsforum.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    /**
     * API route for creating comments */
    @PostMapping("")
    public ResponseEntity<Comment> createComment(@RequestBody CommentCreationDTO commentDetails) {
        Comment comment = commentService.createComment(commentDetails);
        return ResponseEntity.created(URI.create("/api/comments/")).body(comment);
    }

    /**
     * API route for deleting comment by id
     * @param commentId Long
     * @return ResponseEntity
     */
    @DeleteMapping("")
    public ResponseEntity<Void> deleteComment(@RequestBody Long commentId) {
        commentService.deleteCommentById(commentId);
        return ResponseEntity.noContent().build();
    }

}
