package com.ty.hospital.hospitalappboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital.hospitalappboot.dto.Encounter;
import com.ty.hospital.hospitalappboot.dto.Medorder;
import com.ty.hospital.hospitalappboot.dto.Person;
import com.ty.hospital.hospitalappboot.repositery.MedorderRepositery;

@Repository
public class MedorderDao {

	@Autowired
	 private MedorderRepositery medorderRepositery;

	@Autowired
	EncounterDao dao;

	public Medorder saveMedorder(int id, Medorder medorder) {

		Encounter encounter = dao.getEncounterById(id);

		if (encounter != null) {
			medorder.setEncounter(encounter);
			return medorderRepositery.save(medorder);
		}
		return null;
	}

	public Medorder getMedorderById(int id) {
		Optional<Medorder> medorder = medorderRepositery.findById(id);

		if (medorder.isEmpty()) {
			return null;
		}
		return medorder.get();
	}

	public List<Medorder> getAllmedorders() {
		return medorderRepositery.findAll();
	}

	public boolean deleteMedorder(int id) {

		Medorder medorder = getMedorderById(id);
		if (medorder != null) {
			medorderRepositery.deleteById(id);
			return true;
		}
		return false;
	}

	public Medorder updateMedorder(int id, Medorder medorder) {
		Medorder medorder2 = getMedorderById(id);
		if (medorder2 != null) {
			medorderRepositery.save(medorder);
			return medorder;
		}
		return null;
	}

}
