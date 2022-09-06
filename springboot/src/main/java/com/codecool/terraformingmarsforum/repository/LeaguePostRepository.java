package com.codecool.terraformingmarsforum.repository;

import com.codecool.terraformingmarsforum.model.LeaguePost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaguePostRepository extends JpaRepository<LeaguePost, Long> {
}
