package com.codecool.terraformingmarsforum.controller;


import com.codecool.terraformingmarsforum.dto.user.CreateAppUserDTO;
import com.codecool.terraformingmarsforum.model.AppUser;
import com.codecool.terraformingmarsforum.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("/login/{userData}")
    public ResponseEntity<AppUser> getUserByUsernameOrEmail(@PathVariable String userData){
        AppUser appUser = appUserService.getAppUserByUsernameOrEmail(userData);
        return ResponseEntity.ok(appUser);
    }

    @PostMapping("/register")
    public ResponseEntity<AppUser> registerUser(@RequestBody CreateAppUserDTO userDetails) {
        return ResponseEntity.ok(appUserService.createAppUser(userDetails));
    }

}
