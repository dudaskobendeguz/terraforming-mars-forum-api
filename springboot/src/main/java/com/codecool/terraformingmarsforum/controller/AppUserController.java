package com.codecool.terraformingmarsforum.controller;


import com.codecool.terraformingmarsforum.model.AppUser;
import com.codecool.terraformingmarsforum.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;
    private final RestExceptionHandler restExceptionHandler;


    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Long id){
        try {
            AppUser appUser = appUserService.getAppUserById(id);
            return ResponseEntity.ok(appUser);
        } catch (NoSuchElementException msg){
            return restExceptionHandler.handleNoSuchElementException();
        }
    }

}
