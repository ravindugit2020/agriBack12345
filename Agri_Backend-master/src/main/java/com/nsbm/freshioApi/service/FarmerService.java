package com.nsbm.freshioApi.service;

import com.nsbm.freshioApi.dto.CountingDTO;
import com.nsbm.freshioApi.dto.FarmerDTO;

import java.util.ArrayList;

public interface FarmerService {
    void registerFarmer(FarmerDTO dto);

    FarmerDTO searchFarmer(String name);

    CountingDTO getAllFarmers();

    void updateUser(FarmerDTO dto);

    ArrayList<FarmerDTO> getAllFarmerss();

    void deleteFarmer(int id);
}
