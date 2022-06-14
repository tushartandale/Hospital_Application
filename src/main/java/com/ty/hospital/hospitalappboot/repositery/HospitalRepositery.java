package com.ty.hospital.hospitalappboot.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hospital.hospitalappboot.dto.Hospital;

public interface HospitalRepositery extends JpaRepository<Hospital, Integer>{

}
