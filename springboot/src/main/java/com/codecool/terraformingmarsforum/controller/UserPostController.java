package com.codecool.terraformingmarsforum.controller;

import com.codecool.terraformingmarsforum.model.UserPost;
import com.codecool.terraformingmarsforum.service.UserPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user-posts")
@RequiredArgsConstructor
public class UserPostController {

    private final UserPostService userPostService;

    @GetMapping
    public ResponseEntity<List<UserPost>> getAllUserPosts() {
        return ResponseEntity.ok(userPostService.getAllUserPosts());
    }
}
