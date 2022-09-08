package com.codecool.terraformingmarsforum.repository;

import com.codecool.terraformingmarsforum.model.LeagueDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueDetailRepository extends JpaRepository<LeagueDetail, Long> {
}
