package com.codecool.terraformingmarsforum.service;

import com.codecool.terraformingmarsforum.model.UserPost;
import com.codecool.terraformingmarsforum.repository.AppUserRepository;
import com.codecool.terraformingmarsforum.repository.UserPostRepository;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class UserPostServiceTest {

    @Mock
    private UserPostRepository userPostRepository;
    @Mock
    private AppUserRepository appUserRepository;
    private UserPostService userPostService;

    @BeforeEach
    public void init() {
        userPostService = new UserPostService(userPostRepository, appUserRepository);
    }

    private List<UserPost> getUserPosts() {
        List<UserPost> userPosts = new ArrayList<>();
        userPosts.add(UserPost.builder().id(1L).build());
        userPosts.add(UserPost.builder().id(2L).build());
        return userPosts;
    }

    @Test
    public void getAllUserPosts_GetAllUserPosts_ReturnsAllUserPosts() {
        List<UserPost> expected = getUserPosts();
        when(userPostRepository.findAll()).thenReturn(expected);
        List<UserPost> actual = userPostService.getAllUserPosts();
        assertEquals(expected, actual);
    }

    @Test
    public void createUserPost_NewUserPost_HasNewId() {
        Long expected = 1L;
        UserPost userPostWithNewId = UserPost.builder().id(expected).build();
        UserPost userPost = UserPost.builder().build();
        when(userPostRepository.save(userPost)).thenReturn(userPostWithNewId);
        Long actual = userPostService.createUserPost(userPost).getId();
        assertEquals(expected, actual);
    }

    @Test
    public void createUserPost_NewUserPost_HasTimestamp() {
        UserPost userPost = UserPost.builder().build();
        when(userPostRepository.save(userPost)).thenReturn(userPost);
        assertNotNull(userPostService.createUserPost(userPost).getTimestamp());
    }
}
