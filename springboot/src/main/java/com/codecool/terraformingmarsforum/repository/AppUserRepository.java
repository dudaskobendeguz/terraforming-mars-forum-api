package com.codecool.terraformingmarsforum.repository;

import com.codecool.terraformingmarsforum.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findAppUserByUsernameOrEmail(String username, String email);
}
