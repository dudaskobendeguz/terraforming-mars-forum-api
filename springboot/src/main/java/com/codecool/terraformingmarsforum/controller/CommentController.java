package com.codecool.terraformingmarsforum.controller;

import com.codecool.terraformingmarsforum.model.AppUser;
import com.codecool.terraformingmarsforum.model.Comment;
import com.codecool.terraformingmarsforum.model.types.PostType;
import com.codecool.terraformingmarsforum.service.CommentService;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Date;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {


    /**
     * DTO for comment creation. Contains all data for comments, postType and postId. */
    @Data
    @Builder
    protected static class CommentDetails {
        @NonNull
        private AppUser user;
        @NonNull
        private String description;
        @NonNull
        private Date timeStamp;
        @NonNull
        private Long postId;
        @NonNull
        private PostType postType;

        public Comment getComment() {
            return Comment.builder().description(description).timeStamp(timeStamp).user(user).build();
        }
    }

    private final CommentService commentService;

    /**
     * API route for creating comments */
    @PostMapping("")
    public ResponseEntity<Comment> createComment(@RequestBody CommentDetails commentDetails) {
        Comment comment = commentService.createComment(commentDetails.getComment(), commentDetails.getPostType(), commentDetails.getPostId());
        return ResponseEntity.created(URI.create("/api/comments/")).body(comment);
    }

}
