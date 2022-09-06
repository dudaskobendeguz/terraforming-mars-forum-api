package com.codecool.terraformingmarsforum.repository;

import com.codecool.terraformingmarsforum.model.UserPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPostRepository extends JpaRepository<UserPost, Long> {

}
