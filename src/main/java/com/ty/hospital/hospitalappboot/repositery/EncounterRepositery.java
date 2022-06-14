package com.ty.hospital.hospitalappboot.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hospital.hospitalappboot.dto.Encounter;

public interface EncounterRepositery extends JpaRepository<Encounter, Integer>{

}
