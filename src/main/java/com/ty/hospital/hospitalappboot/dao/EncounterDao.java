package com.ty.hospital.hospitalappboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ty.hospital.hospitalappboot.dto.Branch;
import com.ty.hospital.hospitalappboot.dto.Encounter;
import com.ty.hospital.hospitalappboot.dto.Person;
import com.ty.hospital.hospitalappboot.exception.NoIdFoundException;
import com.ty.hospital.hospitalappboot.repositery.EncounterRepositery;

@Repository
public class EncounterDao {

	@Autowired
	EncounterRepositery encounterRepositery;

	@Autowired
	BranchDao branchDao;

	@Autowired
	PersonDao person;

	public Encounter saveEncounter(int bid, int pid, Encounter encounter) {
		Branch branch = branchDao.getbyId(bid);
		Person person1 = person.getById(pid);
		if (person1 != null && branch != null) {
			encounter.setBranch(branch);
			encounter.setPerson(person1);
			return encounterRepositery.save(encounter);
		}
		return null;
	}

	public Encounter getEncounterById(int id) {
		Optional<Encounter> encounter = encounterRepositery.findById(id);

		if (encounter.isEmpty()) {
			return null;
		}
		return encounter.get();
	}

	public Encounter updatebEncounter(int id, Encounter encounter) {
		Encounter encounter2 = getEncounterById(id);
		if (encounter2 != null) {
			encounterRepositery.save(encounter);
			return encounter;
		}
		return null;
	}

	public List<Encounter> getAllEncounters() {
		return encounterRepositery.findAll();
	}

	public boolean removeEncounter(int id) {
		Encounter encounter = getEncounterById(id);
		if (encounter == null) {
			encounterRepositery.deleteById(id);
			return true;
		}
		return false;
	}

}
