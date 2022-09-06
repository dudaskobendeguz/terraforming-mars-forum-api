package com.codecool.terraformingmarsforum.repository;

import com.codecool.terraformingmarsforum.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
