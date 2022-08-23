package com.codecool.terraformingmarsforum.service.DAO.memory;

import com.codecool.terraformingmarsforum.model.Comment;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CommentMemoryTest {

    @Test
    void add_CreateNewCommit_PresentInMemory() {
        Set<Comment> comments = new HashSet<>();
        Comment comment = Comment.builder().build();
        CommentMemory commentMemory = new CommentMemory(comments);
        commentMemory.add(comment);
        assertTrue(comments.contains(comment));
    }
}