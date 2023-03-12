package com.nsbm.freshioApi.service;

import com.nsbm.freshioApi.dto.ProblemDTO;

import java.util.ArrayList;

public interface ProblemService {

    void AddComment(ProblemDTO dto);

    ArrayList<ProblemDTO> getAllProblems();

    void deleteProblem(int id);
}
