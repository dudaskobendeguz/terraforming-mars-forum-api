package com.codecool.terraformingmarsforum.repository;

import com.codecool.terraformingmarsforum.model.UserPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPostRepository extends JpaRepository<UserPost, Long> {

}
