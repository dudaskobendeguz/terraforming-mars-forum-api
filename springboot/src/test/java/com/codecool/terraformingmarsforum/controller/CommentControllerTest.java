package com.codecool.terraformingmarsforum.controller;

import com.codecool.terraformingmarsforum.model.AppUser;
import com.codecool.terraformingmarsforum.model.Comment;
import com.codecool.terraformingmarsforum.model.types.PostType;
import com.codecool.terraformingmarsforum.service.CommentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.Date;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CommentControllerTest {

    @Mock
    private CommentService commentService;
    private CommentController commentController;

    @BeforeEach
    public void init() {
        commentController = new CommentController(commentService);
    }

    @Test
    public void createComment_createComment_returnsStatus201() {
        HttpStatus expected = HttpStatus.CREATED;
        HttpStatus actual = commentController.createComment(CommentController.CommentDetails.builder().build()).getStatusCode();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void createComment_createComment_hasCommentInResponseBody() {
        CommentController.CommentDetails commentDetails = CommentController.CommentDetails.builder()
                .postId(0L)
                .user(AppUser.builder()
                        .id(1L)
                        .build())
                .postType(PostType.LEAGUE)
                .description("desc")
                .timeStamp(new Date())
                .build();

        Comment expected = commentDetails.getComment();
        when(commentService.createComment(
                expected,
                commentDetails.getPostType(),
                commentDetails.getPostId()))
                .thenReturn(expected);

        Comment actual = commentController.createComment(commentDetails).getBody();
        Assertions.assertEquals(expected, actual);
    }

}