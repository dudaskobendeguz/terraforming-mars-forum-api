package com.codecool.terraformingmarsforum.model;

import com.codecool.terraformingmarsforum.service.DAO.CommentDAO;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@Builder
public class Comment {

    private int id;
    private String description;
    private User user;
}
