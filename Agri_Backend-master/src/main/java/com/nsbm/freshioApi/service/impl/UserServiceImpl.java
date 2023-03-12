package com.nsbm.freshioApi.service.impl;

import com.nsbm.freshioApi.dto.FarmerDTO;
import com.nsbm.freshioApi.dto.UserDTO;
import com.nsbm.freshioApi.entity.Farmer;
import com.nsbm.freshioApi.entity.User;
import com.nsbm.freshioApi.exception.ValidateException;
import com.nsbm.freshioApi.repo.UserRepo;
import com.nsbm.freshioApi.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UserDTO searchuser(String name) {
        Optional<User> user = Optional.ofNullable(userRepo.findByName(name));
        if (user.isPresent()) {
            return modelMapper.map(user.get(), UserDTO.class);
        }else {
            throw new ValidateException("No User for This Name..!");
        }
    }
}
