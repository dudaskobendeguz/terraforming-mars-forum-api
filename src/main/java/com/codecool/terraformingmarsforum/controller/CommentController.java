package com.codecool.terraformingmarsforum.controller;

import com.codecool.terraformingmarsforum.model.Comment;
import com.codecool.terraformingmarsforum.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) throws URISyntaxException {
        int id = commentService.createComment(comment);
        return ResponseEntity.created(new URI(String.format("/api/comments/%d", id))).body(comment);
    }
}
