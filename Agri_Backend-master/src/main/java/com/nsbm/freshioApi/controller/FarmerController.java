package com.nsbm.freshioApi.controller;

import com.nsbm.freshioApi.dto.CountingDTO;
import com.nsbm.freshioApi.dto.ExpertDTO;
import com.nsbm.freshioApi.dto.FarmerDTO;
import com.nsbm.freshioApi.service.FarmerService;
import com.nsbm.freshioApi.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("api/v1/farmer")
@CrossOrigin
public class FarmerController {

    @Autowired
    private FarmerService farmerService;

    @PostMapping(path = "/registerFarmer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveFarmer(@RequestBody FarmerDTO dto) {
        farmerService.registerFarmer(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/search/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchFarmerByName(@PathVariable String name) {
        FarmerDTO dto = farmerService.searchFarmer(name);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

    @GetMapping(path = "/countAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllPrducts() {
        CountingDTO allFarmers = farmerService.getAllFarmers();
        return new ResponseEntity(new StandardResponse("200", "Done", allFarmers), HttpStatus.OK);
    }

    @PutMapping(path = ("/updateFarmer"),consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateFarmer(@RequestBody FarmerDTO dto) {
        System.out.println(dto);
        farmerService.updateUser(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

    @GetMapping(path = "/searchAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllFarmrs() {
        ArrayList<FarmerDTO> allexperts = farmerService.getAllFarmerss();
        return new ResponseEntity(new StandardResponse("200", "Done", allexperts), HttpStatus.OK);
    }

    @DeleteMapping(path = "/deleteFarmer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteExpert(@PathVariable int id) {
        farmerService.deleteFarmer(id);
        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
    }


}
