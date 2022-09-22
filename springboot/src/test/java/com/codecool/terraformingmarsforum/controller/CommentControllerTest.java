package com.codecool.terraformingmarsforum.controller;

import com.codecool.terraformingmarsforum.dto.comment.CommentCreationDTO;
import com.codecool.terraformingmarsforum.dto.comment.CommentUpdateDTO;
import com.codecool.terraformingmarsforum.mappers.CommentMapper;
import com.codecool.terraformingmarsforum.model.AppUser;
import com.codecool.terraformingmarsforum.model.Comment;
import com.codecool.terraformingmarsforum.model.types.PostType;
import com.codecool.terraformingmarsforum.service.CommentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CommentControllerTest {

    @Mock
    private CommentService commentService;
    private CommentController commentController;
    private final CommentMapper commentMapper = Mappers.getMapper(CommentMapper.class);
    private Date date;

    @BeforeEach
    public void init() {
        commentController = new CommentController(commentService);
        date = new Date();
    }

    @Test
    public void createComment_createComment_returnsStatus201() {
        HttpStatus expected = HttpStatus.CREATED;
        HttpStatus actual = commentController.createComment(CommentCreationDTO.builder()
                .postId(0L)
                .user(AppUser.builder()
                        .id(1L)
                        .build())
                .postType(PostType.LEAGUE)
                .description("desc")
                .timeStamp(date)
                .build()).getStatusCode();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void createComment_createComment_hasCommentInResponseBody() {
        CommentCreationDTO commentCreationDTO = CommentCreationDTO.builder()
                .postId(0L)
                .user(AppUser.builder()
                        .id(1L)
                        .build())
                .postType(PostType.LEAGUE)
                .description("desc")
                .timeStamp(date)
                .build();

        Comment expected = commentMapper.CommentCreationDTOToComment(commentCreationDTO);
        when(commentService.createComment(commentCreationDTO))
                .thenReturn(expected);
        Comment actual = commentController.createComment(commentCreationDTO).getBody();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void updateComment_updatingComment_returnStatus204() {
        CommentUpdateDTO commentUpdateDTO = CommentUpdateDTO.builder()
                .id(1L)
                .description("desc")
                .isTimestampOverride(false)
                .timeStamp(date)
                .build();
        HttpStatus expected = HttpStatus.NO_CONTENT;
        HttpStatus actual = commentController.updateComment(commentUpdateDTO).getStatusCode();
        assertEquals(expected, actual);
    }

    @Test
    public void deleteComment_deletingComment_returnStatus204() {
        HttpStatus expected = HttpStatus.NO_CONTENT;
        HttpStatus actual = commentController.deleteComment(1L).getStatusCode();
        assertEquals(expected, actual);
    }
}