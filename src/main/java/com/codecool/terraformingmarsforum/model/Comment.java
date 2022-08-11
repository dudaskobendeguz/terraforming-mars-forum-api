package com.codecool.terraformingmarsforum.model;

import com.codecool.terraformingmarsforum.service.DAO.CommentDAO;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@Builder
public class Comment {

    private final int id;
    private final String description;
    private final User user;
}
