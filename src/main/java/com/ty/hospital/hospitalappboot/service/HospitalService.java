package com.ty.hospital.hospitalappboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.hospital.hospitalappboot.dao.HospitalDao;
import com.ty.hospital.hospitalappboot.dto.Hospital;
import com.ty.hospital.hospitalappboot.exception.NoIdFoundException;

@Service
public class HospitalService {

	@Autowired
	private HospitalDao dao;

	public Hospital saveHospital(Hospital hospital) {
		return dao.saveHospital(hospital);

	}

	public Hospital getHospital(int id) {
		Hospital hospital = dao.getById(id);

		if (hospital == null) {
			throw new NoIdFoundException("Given Hospital Id " + id + " Is Not Valid");
		}
		return hospital;
	}

	public List<Hospital> getAllHospitals() {
		return dao.getAllHospitals();
	}

	public boolean removeHospital(int id) {
		boolean b = dao.deleteHospital(id);
		if (b) {
			return true;
		} else {
			throw new NoIdFoundException("Given Id " + id + " Is Not Valid ");
		}
	}

	public Hospital updateHospital(int id, Hospital hospital) {
		Hospital hospital2 = dao.updateHospital(id, hospital);
		if (hospital2 != null) {
			return hospital2;
		}
		throw new NoIdFoundException("Given Id " + id + " Is Not Valid");
	}

}
