package com.codecool.terraformingmarsforum.service.DAO.memory;

import com.codecool.terraformingmarsforum.model.Comment;
import com.codecool.terraformingmarsforum.service.DAO.CommentDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
@RequiredArgsConstructor
public class CommentMemory implements CommentDAO {

    private final Set<Comment> comments;
    private int idCounter;

    @Override
    public Comment add(Comment comment) {
        comments.add(comment);
        comment.setId(idCounter++);
        return comment;
    }
}
