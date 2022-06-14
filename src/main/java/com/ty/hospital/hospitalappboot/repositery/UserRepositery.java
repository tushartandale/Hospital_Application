package com.ty.hospital.hospitalappboot.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hospital.hospitalappboot.dto.User;

public interface UserRepositery extends JpaRepository<User, Integer>{

}
