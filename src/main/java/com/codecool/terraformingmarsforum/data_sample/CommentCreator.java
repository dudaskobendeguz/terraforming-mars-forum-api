package com.codecool.terraformingmarsforum.data_sample;

import com.codecool.terraformingmarsforum.service.DAO.memory.CommentMemory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class CommentCreator {

    private final CommentMemory commentMemory;

    @PostConstruct
    public void initialize() {
        //TODO
    }
}
