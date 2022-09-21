package com.codecool.terraformingmarsforum.controller;

import com.codecool.terraformingmarsforum.dto.CommentCreationDTO;
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

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CommentControllerTest {

    @Mock
    private CommentService commentService;
    private CommentController commentController;
    private final CommentMapper commentMapper = Mappers.getMapper(CommentMapper.class);

    @BeforeEach
    public void init() {
        commentController = new CommentController(commentService);
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
                .timeStamp(new Date())
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
                .timeStamp(new Date())
                .build();

        Comment expected = commentMapper.CommentCreationDTOToComment(commentCreationDTO);
        when(commentService.createComment(commentCreationDTO))
                .thenReturn(expected);
        Comment actual = commentController.createComment(commentCreationDTO).getBody();
        Assertions.assertEquals(expected, actual);
    }

}