package com.codecool.terraformingmarsforum.model;

import com.codecool.terraformingmarsforum.service.DAO.CommentDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class Comment {

    @Autowired
    private CommentDAO commentDAO;
}
