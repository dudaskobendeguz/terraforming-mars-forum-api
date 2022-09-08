package com.codecool.terraformingmarsforum.service;

import com.codecool.terraformingmarsforum.model.AppUser;
import com.codecool.terraformingmarsforum.repository.AppUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AppUserServiceTest {

    @Mock
    private AppUserRepository appUserRepository;
    private AppUserService appUserService;

    @BeforeEach
    public void init() {
        appUserService = new AppUserService(appUserRepository);
    }

    @Test
    void getAppUserById_ValidId_ReturnsAppUser() {
        AppUser expectedTestUser = getAppUser();
        Mockito.when(appUserRepository.findById(1L)).thenReturn(Optional.ofNullable(expectedTestUser));
        AppUser actualTestUser = appUserService.getAppUserById(1L);

        assertEquals(expectedTestUser, actualTestUser);
    }

    private AppUser getAppUser() {
        return AppUser.builder()
                .username("TesztElek")
                .firstName("Teszt")
                .lastName("Elek")
                .email("tesztelek@gmail.com")
                .password("teszt")
                .imgSource("fb/img/tesztelek_profile_pic")
                .timestamp(new Date())
                .build();
    }

    @Test
    public void getAppUserById_InvalidId_ThrowsNoSuchElementException(){
        assertThrows(NoSuchElementException.class, ()-> appUserService.getAppUserById(-1L));
    }


    @Test
    void getAppUserByUsernameOrEmail_ValidUsername_ReturnsAppUser() {
        AppUser expectedTestUser = getAppUser();
        Mockito.when(appUserRepository.findAppUserByUsernameOrEmail("TesztElek", "notValid"))
                .thenReturn(Optional.ofNullable(expectedTestUser));
        AppUser actualTestUser = appUserService.getAppUserByUsernameOrEmail("TesztElek", "notValid");

        assertEquals(expectedTestUser, actualTestUser);
    }
}