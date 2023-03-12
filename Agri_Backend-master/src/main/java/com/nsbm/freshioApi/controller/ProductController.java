package com.nsbm.freshioApi.controller;

import com.nsbm.freshioApi.dto.*;
import com.nsbm.freshioApi.service.ProductService;
import com.nsbm.freshioApi.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/product")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(path = "/saveProduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveExpert(@RequestBody ProductDTO dto) {
        productService.saveProduct(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/searchAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllPrducts() {
        ArrayList<ProductDTO> allProducts = productService.getAllProducts();
        return new ResponseEntity(new StandardResponse("200", "Done", allProducts), HttpStatus.OK);
    }

    @GetMapping(path = "/search/{product_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchFarmerByName(@PathVariable Integer product_id) {
        ProductDTO dto = productService.searchProduct(product_id);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

    @GetMapping(path = "/countAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllcounts() {
        CountsDTO allproducts = productService.countAllProducts();
        return new ResponseEntity(new StandardResponse("200", "Done", allproducts), HttpStatus.OK);
    }

    @PutMapping(path = ("/updateProduct"),consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateProduct(@RequestBody ProductDTO dto) {
        productService.updateProduct(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

    @DeleteMapping(path = "/deleteProduct/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
    }
}
