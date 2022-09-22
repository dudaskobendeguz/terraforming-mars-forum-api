package com.codecool.terraformingmarsforum.service;

import com.codecool.terraformingmarsforum.dto.comment.CommentCreationDTO;
import com.codecool.terraformingmarsforum.dto.comment.CommentUpdateDTO;
import com.codecool.terraformingmarsforum.mappers.CommentMapper;
import com.codecool.terraformingmarsforum.model.Comment;
import com.codecool.terraformingmarsforum.model.types.PostType;
import com.codecool.terraformingmarsforum.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final LeaguePostService leaguePostService;
    private final UserPostService userPostService;
    private final CommentMapper commentMapper;

    /**
     * Saves comment to comment table and links it to post.
     * @param commentDetails CommentCreationDTO -- details unpacked via mapStruct
     * @return savedComment Comment
     */
    public Comment createComment(CommentCreationDTO commentDetails) {
        Comment newComment = commentMapper.CommentCreationDTOToComment(commentDetails);
        PostType postType = commentDetails.getPostType();
        Long postId = commentDetails.getPostId();

        Comment savedComment = commentRepository.save(newComment);
        switch (postType) {
            case USER -> userPostService.addCommentToUserPost(postId, newComment);
            case LEAGUE -> leaguePostService.addCommentToPostByPostId(postId, newComment);
        }
        return savedComment;
    }

    /**
     * Function for deleting comment in commentRepository
     * @param commentId Long
     */
    public void deleteCommentById(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    /**
     * Update comment description and comment timestamp if isTimestampOverride = True
     * @param commentUpdateDTO dto fro comment update
     * @return updated comment
     * @throws NoSuchElementException if comment is not found on specified id
     * @throws IllegalArgumentException if timestamp should be overridden, but timestamp is not provided
     */
    public Comment updateComment(CommentUpdateDTO commentUpdateDTO) {
        Comment comment = commentRepository.findById(commentUpdateDTO.getId()).orElseThrow(NoSuchElementException::new);
        comment.setDescription(commentUpdateDTO.getDescription());
        if (commentUpdateDTO.getIsTimestampOverride()) {
            Date timeStamp = commentUpdateDTO.getTimeStamp();
            if (timeStamp == null) {throw new IllegalArgumentException();}
            comment.setTimeStamp(timeStamp);
        }
        return commentRepository.save(comment);
    }
}
