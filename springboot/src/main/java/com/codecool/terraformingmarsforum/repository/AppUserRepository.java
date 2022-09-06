package com.codecool.terraformingmarsforum.repository;

import com.codecool.terraformingmarsforum.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
}
