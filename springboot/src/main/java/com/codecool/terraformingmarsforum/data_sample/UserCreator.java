package com.codecool.terraformingmarsforum.data_sample;


import com.codecool.terraformingmarsforum.service.DAO.memory.UserMemory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserCreator {

    private final UserMemory userMemory;
}
