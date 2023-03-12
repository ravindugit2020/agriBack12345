package com.nsbm.freshioApi.controller;

import com.nsbm.freshioApi.dto.FarmerDTO;
import com.nsbm.freshioApi.dto.UserDTO;
import com.nsbm.freshioApi.service.UserService;
import com.nsbm.freshioApi.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/search/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchUserByName(@PathVariable String name) {
        UserDTO dto = userService.searchuser(name);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }
}
