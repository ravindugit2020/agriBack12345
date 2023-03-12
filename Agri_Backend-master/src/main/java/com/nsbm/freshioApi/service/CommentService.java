package com.nsbm.freshioApi.service;

import com.nsbm.freshioApi.dto.CommentDTO;

import java.util.ArrayList;

public interface CommentService {
    void addComment(CommentDTO dto);

    ArrayList<CommentDTO> getCommentsByExpertID(String problem_id);
}
