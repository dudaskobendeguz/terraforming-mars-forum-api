package com.codecool.terraformingmarsforum.service;

import com.codecool.terraformingmarsforum.model.AppUser;
import com.codecool.terraformingmarsforum.model.Comment;
import com.codecool.terraformingmarsforum.model.UserPost;
import com.codecool.terraformingmarsforum.repository.AppUserRepository;
import com.codecool.terraformingmarsforum.repository.UserPostRepository;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

    private AppUser getUser() {
        return AppUser.builder().id(1L).build();
    }

    private UserPost getUserPost() {
        return UserPost.builder().user(getUser()).description("").build();
    }

    private Comment getComment() {
        return Comment.builder().id(1L).build();
    }

    /*------------------------------- Get All User Posts -------------------------------*/


    @Test
    public void getAllUserPosts_GetAllUserPosts_ReturnsAllUserPosts() {
        List<UserPost> expected = getUserPosts();

        when(userPostRepository.findAll()).thenReturn(expected);

        List<UserPost> actual = userPostService.getAllUserPosts();
        assertEquals(expected, actual);
    }

    /*------------------------------- Create User Post -------------------------------*/


    @Test
    public void createUserPost_NewUserPost_HasNewId() {
        Long expected = 1L;
        UserPost userPostWithNewId = UserPost.builder().id(expected).build();
        UserPost userPost = getUserPost();

        when(userPostRepository.save(userPost)).thenReturn(userPostWithNewId);
        when(appUserRepository.findById(1L)).thenReturn(Optional.of(getUser()));

        Long actual = userPostService.addUserPost(userPost).getId();
        assertEquals(expected, actual);
    }

    @Test
    public void createUserPost_NewUserPost_HasTimestamp() {
        UserPost userPost = getUserPost();

        when(userPostRepository.save(userPost)).thenReturn(userPost);
        when(appUserRepository.findById(1L)).thenReturn(Optional.of(getUser()));

        assertNotNull(userPostService.addUserPost(userPost).getTimestamp());
    }

    @Test
    public void createUserPost_UserNotFound_ThrowsIllegalArgumentExceptionWithSpecifiedMessage() {
        UserPost userPost = getUserPost();

        when(appUserRepository.findById(1L)).thenReturn(Optional.empty());

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> userPostService.addUserPost(userPost));

        assertEquals("User: 1 not found", illegalArgumentException.getMessage());
    }

    /*------------------------------- Update User Post -------------------------------*/


    @Test
    public void updateUserPost_UpdatingUserPost_UpdatesUserPost() {
        UserPost userPost = getUserPost();
        UserPost updatedUserPost = getUserPost();
        Long id = 1L;
        String expected = "updated description";
        updatedUserPost.setDescription(expected);

        when(userPostRepository.findById(id)).thenReturn(Optional.of(userPost));
        when(userPostRepository.save(any(UserPost.class))).thenReturn(userPost);

        userPostService.updateUserPost(id, updatedUserPost);

        String actual = userPost.getDescription();
        assertEquals(expected, actual);
    }

    @Test
    public void updateUserPost_UserPostNotFound_ThrowsIllegalArgumentException() {
        when(userPostRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> userPostService.updateUserPost(1L, getUserPost()));
    }

    /*------------------------------- Delete User Post -------------------------------*/


    @Test
    public void deleteUserPost_DeletingUserPost_InvokesRepositoryDeleteExactlyOnce() {
        UserPost userPost = getUserPost();
        Long id = 1L;

        when(userPostRepository.findById(id)).thenReturn(Optional.of(userPost));

        userPostService.deleteUserPost(id);

        verify(userPostRepository, times(1)).deleteById(id);
    }

    @Test
    public void deleteUserPost_UserPostNotFound_ThrowsNoSuchElementException() {
        when(userPostRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> userPostService.deleteUserPost(1L));
    }


    /*------------------------------- Add Comment To User Post -------------------------------*/

    @Test
    public void addCommentToUserPost_AfterAddingComment_CommentIsPresentInUserPost() {
        UserPost userPost = getUserPost();
        Long id = userPost.getId();
        Comment comment = getComment();

        when(userPostRepository.findById(id)).thenReturn(Optional.of(userPost));
        when(userPostRepository.save(any(UserPost.class))).thenReturn(userPost);

        userPostService.addCommentToUserPost(userPost.getId(), comment);

        assertTrue(userPost.getComments().contains(comment));
    }

}
