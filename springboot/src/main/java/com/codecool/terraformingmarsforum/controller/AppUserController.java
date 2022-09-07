package com.codecool.terraformingmarsforum.controller;


import com.codecool.terraformingmarsforum.model.AppUser;
import com.codecool.terraformingmarsforum.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * AppUserController is responsible for control any USER ACTIVITIES on site such as:
 * - registration
 * - login
 * - profile page
 */
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;

    @GetMapping("/{id}")
    public ResponseEntity<AppUser> getUserById(@PathVariable Long id){
            AppUser appUser = appUserService.getAppUserById(id);
            return ResponseEntity.ok(appUser);
    }

}
