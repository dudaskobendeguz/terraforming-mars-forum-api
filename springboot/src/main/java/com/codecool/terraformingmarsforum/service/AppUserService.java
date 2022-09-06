package com.codecool.terraformingmarsforum.service;


import com.codecool.terraformingmarsforum.repository.AppUserRepository;
import com.codecool.terraformingmarsforum.service.DAO.UserDAO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserService {

    @NonNull
    private UserDAO userDAO;
    private AppUserRepository appUserRepository;
}
