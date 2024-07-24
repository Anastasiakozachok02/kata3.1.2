package com.example.kata3_1_2.dao;

import com.example.kata3_1_2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {


}
