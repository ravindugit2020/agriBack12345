package com.nsbm.freshioApi.service.impl;

import com.nsbm.freshioApi.dto.CommentDTO;
import com.nsbm.freshioApi.entity.Comment;
import com.nsbm.freshioApi.repo.CommentRepo;
import com.nsbm.freshioApi.service.CommentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addComment(CommentDTO dto) {
        commentRepo.save(modelMapper.map(dto, Comment.class));
    }

    @Override
    public ArrayList<CommentDTO> getCommentsByExpertID(String problem_id) {
        System.out.println("ok2");
        List<Comment> all = commentRepo.findAllByProblem(problem_id);
        return modelMapper.map(all, new TypeToken<ArrayList<CommentDTO>>() {
        }.getType());
    }
}
