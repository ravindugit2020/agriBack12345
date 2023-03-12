package com.nsbm.freshioApi.service;

import com.nsbm.freshioApi.dto.CountsDTO;
import com.nsbm.freshioApi.dto.ProductDTO;

import java.util.ArrayList;

public interface ProductService {
    void saveProduct(ProductDTO dto);

    ArrayList<ProductDTO> getAllProducts();

    ProductDTO searchProduct(Integer name);

    CountsDTO countAllProducts();

    void updateProduct(ProductDTO dto);

    void deleteProduct(int id);
}
