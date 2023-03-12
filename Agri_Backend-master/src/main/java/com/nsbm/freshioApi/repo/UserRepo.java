package com.nsbm.freshioApi.repo;

import com.nsbm.freshioApi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,Integer> {

    @Query(value = "SELECT * FROM user WHERE user_name=?1", nativeQuery = true)
    User findByName(String name);

}
