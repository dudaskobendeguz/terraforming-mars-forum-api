package com.codecool.terraformingmarsforum.controller;

import com.codecool.terraformingmarsforum.model.Comment;
import com.codecool.terraformingmarsforum.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) throws URISyntaxException {
        commentService.createComment(comment);
        return ResponseEntity.created(new URI("/api/comments/")).body(comment);
    }


}
