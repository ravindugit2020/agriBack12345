package com.nsbm.freshioApi.service;

import com.nsbm.freshioApi.dto.ExpertDTO;
import com.nsbm.freshioApi.dto.FarmerDTO;

import java.util.ArrayList;

public interface ExpertService {
    void registerExpert(ExpertDTO dto);

    ExpertDTO searchExpert(String name);

    ArrayList<ExpertDTO> getAllExperts();

    void updateExpert(ExpertDTO dto);

    void deleteExpert(int id);
}
