package com.nsbm.freshioApi.service.impl;

import com.nsbm.freshioApi.dto.ProblemDTO;
import com.nsbm.freshioApi.entity.Problem;
import com.nsbm.freshioApi.exception.ValidateException;
import com.nsbm.freshioApi.repo.ProblemRepo;
import com.nsbm.freshioApi.service.ProblemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProblemServiceImpl implements ProblemService {

    @Autowired
    private ProblemRepo problemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void AddComment(ProblemDTO dto) {
        problemRepo.save(modelMapper.map(dto, Problem.class));
    }

    @Override
    public ArrayList<ProblemDTO> getAllProblems() {
        List<Problem> all = problemRepo.findAll();
        return modelMapper.map(all, new TypeToken<ArrayList<ProblemDTO>>() {
        }.getType());
    }

    @Override
    public void deleteProblem(int id) {
        if (!problemRepo.existsById(id)) {
            throw new ValidateException("No Problem for Delete..!");
        }
        problemRepo.deleteById(id);
    }
}
