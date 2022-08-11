package com.codecool.terraformingmarsforum.service.DAO.memory;

import com.codecool.terraformingmarsforum.model.Post;
import com.codecool.terraformingmarsforum.service.DAO.PostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
@RequiredArgsConstructor
public class PostMemory implements PostDAO {

    private final Set<Post> posts;

}

