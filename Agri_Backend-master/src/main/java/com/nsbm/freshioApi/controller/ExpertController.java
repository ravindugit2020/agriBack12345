package com.nsbm.freshioApi.controller;

import com.nsbm.freshioApi.dto.ExpertDTO;
import com.nsbm.freshioApi.dto.FarmerDTO;
import com.nsbm.freshioApi.service.ExpertService;
import com.nsbm.freshioApi.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
    @RequestMapping("api/v1/expert")
@CrossOrigin
public class ExpertController {

    @Autowired
    private ExpertService expertService;

    @PostMapping(path = "/registerExpert", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveExpert(@RequestBody ExpertDTO dto) {
        expertService.registerExpert(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/search/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchExpertByName(@PathVariable String name) {
        ExpertDTO dto = expertService.searchExpert(name);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

    @GetMapping(path = "/searchAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllExprts() {
        ArrayList<ExpertDTO> allexperts = expertService.getAllExperts();
        return new ResponseEntity(new StandardResponse("200", "Done", allexperts), HttpStatus.OK);
    }

    @PutMapping(path = ("/updateExpert"),consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateExpert(@RequestBody ExpertDTO dto) {
        expertService.updateExpert(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

    @DeleteMapping(path = "/deleteExpert/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteExpert(@PathVariable int id) {
        expertService.deleteExpert(id);
        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
    }
}
