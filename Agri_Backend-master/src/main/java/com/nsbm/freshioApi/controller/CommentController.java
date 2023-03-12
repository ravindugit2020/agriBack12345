package com.nsbm.freshioApi.controller;

import com.nsbm.freshioApi.dto.CommentDTO;
import com.nsbm.freshioApi.service.CommentService;
import com.nsbm.freshioApi.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/comment")
@CrossOrigin
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping(path = "/AddComment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveComment(@RequestBody CommentDTO dto) {
        commentService.addComment(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/getAllComments/{problem_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getProductsByUserID(@PathVariable String problem_id) {
        System.out.println("ok");
        ArrayList<CommentDTO> allCommentsByProblem = commentService.getCommentsByExpertID(problem_id);
        return new ResponseEntity(new StandardResponse("200", "Done", allCommentsByProblem), HttpStatus.OK);
    }

}
