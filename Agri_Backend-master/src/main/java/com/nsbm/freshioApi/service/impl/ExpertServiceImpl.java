package com.nsbm.freshioApi.service.impl;

import com.nsbm.freshioApi.dto.ExpertDTO;
import com.nsbm.freshioApi.entity.Expert;
import com.nsbm.freshioApi.entity.Farmer;
import com.nsbm.freshioApi.exception.ValidateException;
import com.nsbm.freshioApi.repo.ExpertRepo;
import com.nsbm.freshioApi.service.ExpertService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExpertServiceImpl implements ExpertService {

    @Autowired
    private ExpertRepo expertRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void registerExpert(ExpertDTO dto) {
        expertRepo.save(modelMapper.map(dto, Expert.class));
    }

    @Override
    public ExpertDTO searchExpert(String name) {
        Optional<Expert> expert = Optional.ofNullable(expertRepo.findByName(name));
        if (expert.isPresent()) {
            return modelMapper.map(expert.get(), ExpertDTO.class);
        }else {
            throw new ValidateException("No Expert for This Name..!");
        }
    }

    @Override
    public ArrayList<ExpertDTO> getAllExperts() {
        List<Expert> all = expertRepo.findAll();
        return modelMapper.map(all, new TypeToken<ArrayList<ExpertDTO>>() {
        }.getType());
    }

    @Override
    public void updateExpert(ExpertDTO dto) {
        if (expertRepo.existsById(dto.getExpert_id())) {
            expertRepo.save(modelMapper.map(dto, Expert.class));
        }
        else {
            throw new ValidateException("No Expert for This Id..!");
        }
    }

    @Override
    public void deleteExpert(int id) {
        if (!expertRepo.existsById(id)) {
            throw new ValidateException("No Expert for Delete..!");
        }
        expertRepo.deleteById(id);
    }
}
