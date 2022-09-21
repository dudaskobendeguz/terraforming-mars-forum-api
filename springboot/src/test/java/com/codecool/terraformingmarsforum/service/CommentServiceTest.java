package com.codecool.terraformingmarsforum.service;

import com.codecool.terraformingmarsforum.dto.comment.CommentCreationDTO;
import com.codecool.terraformingmarsforum.dto.comment.CommentUpdateDTO;
import com.codecool.terraformingmarsforum.mappers.CommentMapper;
import com.codecool.terraformingmarsforum.model.AppUser;
import com.codecool.terraformingmarsforum.model.Comment;
import com.codecool.terraformingmarsforum.model.types.PostType;
import com.codecool.terraformingmarsforum.repository.CommentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
    private Date date;


    @BeforeEach
    public void init() {
        commentService = new CommentService(commentRepository, leaguePostService, userPostService, commentMapper);
        date = new Date();
    }

    private CommentCreationDTO getCommentCreationDTO() {
        return CommentCreationDTO.builder()
                .postId(1L)
                .postType(PostType.LEAGUE)
                .timeStamp(date)
                .user(AppUser.builder().id(1L).build())
                .description("League has been created")
                .build();
    }

    @Test
        public void createComment_commentCreationUserPost_commentSavedToCommentTable() {
            CommentCreationDTO commentCreationDTO = getCommentCreationDTO();
            commentCreationDTO.setPostType(PostType.USER);
            Comment comment = commentMapper.CommentCreationDTOToComment(commentCreationDTO);
            when(commentRepository.save(comment)).thenReturn(comment);
            Comment actual = commentService.createComment(commentCreationDTO);
            assertEquals(comment, actual);
    }

    @Test
    public void createComment_commentCreationForLeaguePost_commentSavedToCommentTable() {
        CommentCreationDTO commentCreationDTO = getCommentCreationDTO();
        Comment comment = commentMapper.CommentCreationDTOToComment(commentCreationDTO);
        when(commentRepository.save(comment)).thenReturn(comment);
        Comment actual = commentService.createComment(commentCreationDTO);
        assertEquals(comment, actual);
    }

    @Test
    public void deleteComment_commentDeletionById_commentNotInDB() {
        Long commentId = 1L;
        commentService.deleteCommentById(commentId);

        verify(commentRepository, times(1)).deleteById(commentId);
    }

    @Test
    public void updateComment_commentCorrectUpdate_commentUpdatedWithoutException() {
        CommentUpdateDTO commentUpdateDTO = CommentUpdateDTO.builder()
                .id(1L)
                .description("desc")
                .isTimestampOverride(true)
                .timeStamp(date)
                .build();
        Comment commentInRepository = Comment.builder()
                .id(1L)
                .description("")
                .timeStamp(null)
                .user(AppUser.builder()
                        .id(1L)
                        .build())
                .build();
        Comment expected = Comment.builder()
                .id(1L)
                .description("desc")
                .timeStamp(date)
                .user(AppUser.builder()
                        .id(1L)
                        .build())
                .build();

        when(commentRepository.findById(1L)).thenReturn(Optional.ofNullable(commentInRepository));
        when(commentRepository.save(commentInRepository)).thenReturn(commentInRepository);

        Comment actual = commentService.updateComment(commentUpdateDTO);
        assertEquals(expected, actual);
    }

    @Test
    public void updateComment_commentUpdateWithoutTimestamp_throwIllegalArgumentException() {
        CommentUpdateDTO commentUpdateDTO = CommentUpdateDTO.builder()
                .id(1L)
                .description("desc")
                .isTimestampOverride(true)
                .timeStamp(null)
                .build();
        Comment commentInRepository = Comment.builder()
                .id(1L)
                .description("desc")
                .timeStamp(date)
                .user(AppUser.builder()
                        .id(1L)
                        .build())
                .build();

        when(commentRepository.findById(1L)).thenReturn(Optional.ofNullable(commentInRepository));

        assertThrows(IllegalArgumentException.class, () -> commentService.updateComment(commentUpdateDTO));
    }

    @Test
    public void updateComment_commentUpdateWithWrongId_throwNoSuchElementException() {
        CommentUpdateDTO commentUpdateDTO = CommentUpdateDTO.builder()
                .id(99L)
                .description("desc")
                .isTimestampOverride(false)
                .timeStamp(null)
                .build();

        assertThrows(NoSuchElementException.class, () -> commentService.updateComment(commentUpdateDTO));
    }
}