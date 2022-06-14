package com.ty.hospital.hospitalappboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospital.hospitalappboot.dto.Hospital;
import com.ty.hospital.hospitalappboot.dto.Person;
import com.ty.hospital.hospitalappboot.exception.NoIdFoundException;
import com.ty.hospital.hospitalappboot.repositery.PersonRepositery;

@Repository
public class PersonDao {

	@Autowired
	PersonRepositery pe;

	public Person savePerson(Person person) {
		return pe.save(person);
	}

	public Person getById(int id) {
		Optional<Person> person = pe.findById(id);
		if (person.isEmpty()) {
			return null;
		}
		return person.get();
	}

	public List<Person> getAllPersons() {
		return pe.findAll();
	}

	public boolean deletePerson(int id) {

		Person person = getById(id);
		if (person != null) {
			pe.deleteById(id);
			return true;
		}
		return false;
	}

	public Person updatePerson(int id, Person person) {
		Person person2 = getById(id);
		if (person2 != null) {
			pe.save(person);
			return person;
		}
		return null;
	}
}
