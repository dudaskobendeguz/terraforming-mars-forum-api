package com.codecool.terraformingmarsforum.service;


import com.codecool.terraformingmarsforum.repository.AppUserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserService {

    private final AppUserRepository appUserRepository;
}
