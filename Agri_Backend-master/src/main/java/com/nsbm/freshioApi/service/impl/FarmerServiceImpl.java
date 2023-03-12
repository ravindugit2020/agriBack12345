package com.nsbm.freshioApi.service.impl;

import com.nsbm.freshioApi.dto.CountingDTO;
import com.nsbm.freshioApi.dto.ExpertDTO;
import com.nsbm.freshioApi.dto.FarmerDTO;
import com.nsbm.freshioApi.entity.Expert;
import com.nsbm.freshioApi.entity.Farmer;
import com.nsbm.freshioApi.exception.ValidateException;
import com.nsbm.freshioApi.repo.FarmerRepo;
import com.nsbm.freshioApi.service.FarmerService;
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
public class FarmerServiceImpl implements FarmerService {

    @Autowired
    private FarmerRepo farmerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CountingDTO countingDTO;

    @Override
    public void registerFarmer(FarmerDTO dto) {

        farmerRepo.save(modelMapper.map(dto, Farmer.class));
    }

    @Override
    public FarmerDTO searchFarmer(String name) {
        Optional<Farmer> farmer = Optional.ofNullable(farmerRepo.findByName(name));
        if (farmer.isPresent()) {
            return modelMapper.map(farmer.get(), FarmerDTO.class);
        }else {
            throw new ValidateException("No Expert for This Name..!");
        }
    }

    @Override
    public CountingDTO getAllFarmers() {
        HashMap<String,Object> countingObj=farmerRepo.getcountFertilizers();

        countingDTO.setAll(countingObj.get("all").toString());
        countingDTO.setChemical(countingObj.get("chemical").toString());
        countingDTO.setNatural(countingObj.get("natural").toString());
        countingDTO.setBoth(countingObj.get("both").toString());
        return countingDTO;
    }

    @Override
    public void updateUser(FarmerDTO dto) {
        if (farmerRepo.existsById(dto.getFarmer_id())) {
            farmerRepo.save(modelMapper.map(dto, Farmer.class));
        }
        else {
            throw new ValidateException("No User for This Email..!");
        }
    }

    @Override
    public ArrayList<FarmerDTO> getAllFarmerss() {
        List<Farmer> all = farmerRepo.findAll();
        return modelMapper.map(all, new TypeToken<ArrayList<FarmerDTO>>() {
        }.getType());
    }

    @Override
    public void deleteFarmer(int id) {
        if (!farmerRepo.existsById(id)) {
            throw new ValidateException("No Farmer for Delete..!");
        }
        farmerRepo.deleteById(id);
    }

}
