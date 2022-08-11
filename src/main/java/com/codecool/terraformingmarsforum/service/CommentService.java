package com.codecool.terraformingmarsforum.service;

import com.codecool.terraformingmarsforum.service.DAO.CommentDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentDAO commentDAO;

}
