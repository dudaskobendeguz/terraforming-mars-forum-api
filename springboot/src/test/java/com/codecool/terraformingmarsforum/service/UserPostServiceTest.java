package com.codecool.terraformingmarsforum.service;

import com.codecool.terraformingmarsforum.model.UserPost;
import com.codecool.terraformingmarsforum.repository.UserPostRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class UserPostServiceTest {

    @Mock
    private UserPostRepository userPostRepository;
    private UserPostService userPostService;

    @BeforeEach
    public void init() {
        userPostService = new UserPostService(userPostRepository);
    }

    private List<UserPost> getUserPosts() {
        List<UserPost> userPosts = new ArrayList<>();
        userPosts.add(UserPost.builder().id(1L).build());
        userPosts.add(UserPost.builder().id(2L).build());
        return userPosts;
    }

    @Test
    public void getAllUserPosts_ReturnsAllUserPosts() {
        List<UserPost> expected = getUserPosts();
        Mockito.when(userPostRepository.findAll()).thenReturn(expected);
        List<UserPost> actual = userPostService.getAllUserPosts();
        Assertions.assertEquals(expected, actual);
    }
}
