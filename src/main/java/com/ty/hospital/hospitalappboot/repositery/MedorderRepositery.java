package com.ty.hospital.hospitalappboot.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hospital.hospitalappboot.dto.Medorder;

public interface MedorderRepositery extends JpaRepository<Medorder, Integer> {

}
