package com.codecool.terraformingmarsforum.service;

import com.codecool.terraformingmarsforum.model.Comment;
import com.codecool.terraformingmarsforum.model.types.PostType;
import com.codecool.terraformingmarsforum.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final LeaguePostService leaguePostService;
    private final UserPostService userPostService;

    /**
     * Saves comment to comment table and links it to post.
     * @param   comment Comment
     * @param   postType PostType
     * @param   postId Long*/
    public Comment createComment(Comment comment, PostType postType, Long postId) {
        Comment result = commentRepository.save(comment);
        switch (postType) {
            case USER -> userPostService.addCommentToUserPost(postId, comment);
            case LEAGUE -> leaguePostService.addCommentToPostByPostId(postId, comment);
        }
        return result;
    }

    /**
     * Function for deleting comment in commentRepository
     * @param commentId Long
     */
    public void deleteCommentById(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
