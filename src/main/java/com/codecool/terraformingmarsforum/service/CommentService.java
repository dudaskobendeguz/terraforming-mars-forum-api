package com.codecool.terraformingmarsforum.service;

import com.codecool.terraformingmarsforum.service.DAO.CommentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentDAO commentDAO;

}
