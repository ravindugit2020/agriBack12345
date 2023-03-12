package com.nsbm.freshioApi.repo;

import com.nsbm.freshioApi.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepo  extends JpaRepository<Comment, Integer> {

    @Query(value = "SELECT * FROM comment where problem_id=?1", nativeQuery = true)
    List<Comment> findAllByProblem(String problem_id);
}
