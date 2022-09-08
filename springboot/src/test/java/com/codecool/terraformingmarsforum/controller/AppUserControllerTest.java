package com.codecool.terraformingmarsforum.controller;

import com.codecool.terraformingmarsforum.service.AppUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AppUserControllerTest {

    @Mock
    private AppUserService appUserService;
    private AppUserController appUserController;

    @BeforeEach
    public void init(){
        appUserController = new AppUserController(appUserService);
    }

    @Test
    public void getUserById_HasStatus200() {
        HttpStatus expected = HttpStatus.OK;
        HttpStatus actual = appUserController.getUserById(1L).getStatusCode();

        assertEquals(expected, actual);
    }
}