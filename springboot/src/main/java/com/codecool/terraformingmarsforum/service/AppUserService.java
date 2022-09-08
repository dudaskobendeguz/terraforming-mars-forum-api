package com.codecool.terraformingmarsforum.service;

import com.codecool.terraformingmarsforum.model.AppUser;
import com.codecool.terraformingmarsforum.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AppUserService {

    private final AppUserRepository appUserRepository;

    public AppUser getAppUserById(Long id) {
        return appUserRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    /**
     * This method tries to get a user from the DB using username or email.
     * Any valid username OR email is acceptable
     * @param username of the user
     *                 OR
     * @param email of the user
     * @return AppUser Object if username or email is exists, throws NoSuchElementException anyway
     */
    public AppUser getAppUserByUsernameOrEmail(String username, String email) {
        return appUserRepository.findAppUserByUsernameOrEmail(username, email).orElseThrow(NoSuchElementException::new);
    }
}
