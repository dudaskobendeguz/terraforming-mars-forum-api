package com.codecool.terraformingmarsforum.service;

import com.codecool.terraformingmarsforum.dto.CommentCreationDTO;
import com.codecool.terraformingmarsforum.mappers.CommentMapper;
import com.codecool.terraformingmarsforum.model.AppUser;
import com.codecool.terraformingmarsforum.model.Comment;
import com.codecool.terraformingmarsforum.model.types.PostType;
import com.codecool.terraformingmarsforum.repository.CommentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CommentServiceTest {

    @Mock
    private CommentRepository commentRepository;
    @Mock
    private LeaguePostService leaguePostService;
    @Mock
    private UserPostService userPostService;
    private CommentService commentService;
    private final CommentMapper commentMapper = Mappers.getMapper(CommentMapper.class);


    @BeforeEach
    public void init() {
        commentService = new CommentService(commentRepository, leaguePostService, userPostService, commentMapper);
    }

    private static CommentCreationDTO getCommentCreationDTO() {
        return CommentCreationDTO.builder()
                .postId(1L)
                .postType(PostType.LEAGUE)
                .timeStamp(new Date())
                .user(AppUser.builder().id(1L).build())
                .description("League has been created")
                .build();
    }

    @Test
        public void createComment_commentCreation_commentSavedToCommentTable() {
            CommentCreationDTO commentCreationDTO = getCommentCreationDTO();
            Comment comment = commentMapper.CommentCreationDTOToComment(commentCreationDTO);
            when(commentRepository.save(comment)).thenReturn(comment);
            Comment actual = commentService.createComment(commentCreationDTO);
            Assertions.assertEquals(comment, actual);
    }

    @Test
    public void deleteComment_commentDeletionById_commentNotInDB() {
        Long commentId = 1L;
        commentService.deleteCommentById(commentId);

        verify(commentRepository, times(1)).deleteById(commentId);
    }

}