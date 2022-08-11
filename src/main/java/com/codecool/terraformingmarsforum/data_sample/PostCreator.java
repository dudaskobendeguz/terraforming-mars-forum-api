package com.codecool.terraformingmarsforum.data_sample;

import com.codecool.terraformingmarsforum.service.DAO.memory.PostMemory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class PostCreator {

    private final PostMemory postMemory;

    @PostConstruct
    public void initialize() {
        // TODO
        System.out.println("Adding values to PostMemory...");
    }

}
