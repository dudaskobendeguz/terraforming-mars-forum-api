package com.codecool.terraformingmarsforum.repository;

import com.codecool.terraformingmarsforum.model.LeaguePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaguePostRepository extends JpaRepository<LeaguePost, Long> {
}
