package com.codecool.terraformingmarsforum.service;

import com.codecool.terraformingmarsforum.service.DAO.PostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostDAO postDAO;

}
