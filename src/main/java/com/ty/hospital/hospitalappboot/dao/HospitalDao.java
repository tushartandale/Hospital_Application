package com.ty.hospital.hospitalappboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital.hospitalappboot.dto.Branch;
import com.ty.hospital.hospitalappboot.dto.Hospital;
import com.ty.hospital.hospitalappboot.exception.NoIdFoundException;
import com.ty.hospital.hospitalappboot.repositery.HospitalRepositery;

@Repository
public class HospitalDao {

	@Autowired
	HospitalRepositery hospitalRepositery;

	public Hospital saveHospital(Hospital hospital) {

		List<Branch> branchs = hospital.getBranchs();

		for (Branch branch : branchs) {
			branch.setHospital(hospital);
		}

		return hospitalRepositery.save(hospital);
	}

	public Hospital getById(int id) {
		Optional<Hospital> optional = hospitalRepositery.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}

	public List<Hospital> getAllHospitals() {
		return hospitalRepositery.findAll();
	}

	public Hospital updateHospital(int id, Hospital hospital) {
		Hospital hospital2 = getById(id);
		if (hospital != null) {
			hospitalRepositery.save(hospital);
			return hospital;
		}
		return null;
	}

	public boolean deleteHospital(int id) {
		Hospital hospital = getById(id);
		if (hospital != null) {
			hospitalRepositery.deleteById(id);
			return true;
		}
		return false;
	}
}
