package com.nsbm.freshioApi.service;

import com.nsbm.freshioApi.dto.UserDTO;

public interface UserService {
    UserDTO searchuser(String name);
}
