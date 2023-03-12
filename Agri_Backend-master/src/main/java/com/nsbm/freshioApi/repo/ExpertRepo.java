package com.nsbm.freshioApi.repo;

import com.nsbm.freshioApi.entity.Expert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExpertRepo extends JpaRepository<Expert, Integer> {

    @Query(value = "SELECT * FROM expert WHERE expert_name=?1", nativeQuery = true)
    Expert findByName(String name);
}
