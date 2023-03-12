package com.nsbm.freshioApi.repo;

import com.nsbm.freshioApi.entity.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemRepo extends JpaRepository<Problem,Integer> {

}
