package com.codecool.terraformingmarsforum.service;

import com.codecool.terraformingmarsforum.model.Comment;
import com.codecool.terraformingmarsforum.model.types.PostType;
import com.codecool.terraformingmarsforum.repository.CommentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CommentServiceTest {

    @Mock
    private CommentRepository commentRepository;
    @Mock
    private LeaguePostService leaguePostService;
    @Mock
    private UserPostService userPostService;
    private CommentService commentService;

    @BeforeEach
    public void init() {
        commentService = new CommentService(commentRepository, leaguePostService, userPostService);
    }

    @Test
    public void createComment_commentCreation_commentSavedToCommentTable() {
        Comment comment = Comment.builder().id(1L).build();
        when(commentRepository.save(comment)).thenReturn(comment);
        Comment actual = commentService.createComment(comment, PostType.LEAGUE, 1L);
        Assertions.assertEquals(comment, actual);
    }

}