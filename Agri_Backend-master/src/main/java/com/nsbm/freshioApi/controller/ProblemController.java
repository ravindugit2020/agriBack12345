package com.nsbm.freshioApi.controller;

import com.nsbm.freshioApi.dto.ProblemDTO;
import com.nsbm.freshioApi.service.ProblemService;
import com.nsbm.freshioApi.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/problem")
@CrossOrigin
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    @PostMapping(path = "/saveProblem", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveProblem(@RequestBody ProblemDTO dto) {
        problemService.AddComment(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/searchAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllPrblemss() {
        ArrayList<ProblemDTO> allProblems = problemService.getAllProblems();
        return new ResponseEntity(new StandardResponse("200", "Done", allProblems), HttpStatus.OK);
    }

    @DeleteMapping(path = "/deleteProblem/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteProblem(@PathVariable int id) {
        problemService.deleteProblem(id);
        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
    }
}
