package com.codecool.terraformingmarsforum.controller;

import com.codecool.terraformingmarsforum.service.AppUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class AppUserControllerTest {

    @Mock
    private AppUserService appUserService;
    private AppUserController appUserController;

    @BeforeEach
    public void init(){
        appUserController = new AppUserController(appUserService);
    }

    @Test
    void getUserById() {
    }
}