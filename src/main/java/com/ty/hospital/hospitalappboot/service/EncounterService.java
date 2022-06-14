package com.ty.hospital.hospitalappboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.hospital.hospitalappboot.dao.EncounterDao;
import com.ty.hospital.hospitalappboot.dao.PersonDao;
import com.ty.hospital.hospitalappboot.dto.Encounter;
import com.ty.hospital.hospitalappboot.exception.NoIdFoundException;

@Service
public class EncounterService {

	@Autowired
	private EncounterDao dao;

	public Encounter saveEncounter(int bid, int pid, Encounter encounter) {
		Encounter encounter2 = dao.saveEncounter(bid, pid, encounter);
		if (encounter2 != null) {
			return dao.saveEncounter(bid, pid, encounter2);
		}
		throw new NoIdFoundException("Given Person Id " + pid + " OR Branch Id " + bid + " Is Not Exist");

	}

	public Encounter getEncounter(int id) {
		Encounter encounter = dao.getEncounterById(id);
		if (encounter == null) {
			throw new NoIdFoundException("Given Encounter Id " + id + " Is Not Exist ");
		}
		return encounter;
	}

	public List<Encounter> getAllEncounters() {
		return dao.getAllEncounters();
	}

	public boolean removeEncounter(int id) {
		boolean b = dao.removeEncounter(id);
		if (b == false) {
			throw new NoIdFoundException("Given Id Is Not Valid");

		}
		return true;

	}
}
