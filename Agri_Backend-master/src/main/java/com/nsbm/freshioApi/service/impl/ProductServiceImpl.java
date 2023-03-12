package com.nsbm.freshioApi.service.impl;

import com.nsbm.freshioApi.dto.*;
import com.nsbm.freshioApi.entity.Expert;
import com.nsbm.freshioApi.entity.Product;
import com.nsbm.freshioApi.exception.ValidateException;
import com.nsbm.freshioApi.repo.ProductRepo;
import com.nsbm.freshioApi.service.ProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CountsDTO countingDTO;

    @Override
    public void saveProduct(ProductDTO dto) {
        productRepo.save(modelMapper.map(dto, Product.class));
    }

    @Override
    public ArrayList<ProductDTO> getAllProducts() {
        List<Product> all = productRepo.findAll();
        return modelMapper.map(all, new TypeToken<ArrayList<ProductDTO>>() {
        }.getType());
    }

    @Override
    public ProductDTO searchProduct(Integer product_id) {
        Optional<Product> product = Optional.ofNullable(productRepo.findByName(product_id));
        if (product.isPresent()) {
            return modelMapper.map(product.get(), ProductDTO.class);
        }else {
            throw new ValidateException("No Expert for This Name..!");
        }
    }

    @Override
    public CountsDTO countAllProducts() {
        HashMap<String,Object> countingObjs=productRepo.getproductFertilizers();

        countingDTO.setPall(countingObjs.get("all").toString());
        countingDTO.setPchemical(countingObjs.get("chemical").toString());
        countingDTO.setPnatural(countingObjs.get("natural").toString());
        countingDTO.setPboth(countingObjs.get("both").toString());
        return countingDTO;
    }

    @Override
    public void updateProduct(ProductDTO dto) {
        if (productRepo.existsById(dto.getProduct_id())) {
            productRepo.save(modelMapper.map(dto, Product.class));
        }
        else {
            throw new ValidateException("No Product for This Id..!");
        }
    }

    @Override
    public void deleteProduct(int id) {
        if (!productRepo.existsById(id)) {
            throw new ValidateException("No Expert for Delete..!");
        }
        productRepo.deleteById(id);
    }
}
