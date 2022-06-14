package com.ty.hospital.hospitalappboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.hospital.hospitalappboot.dao.PersonDao;
import com.ty.hospital.hospitalappboot.dto.Person;
import com.ty.hospital.hospitalappboot.exception.NoIdFoundException;

@Service
public class PersonService {

	@Autowired
	private PersonDao dao;

	public Person savePerson(Person person) {
		return dao.savePerson(person);
	}

	public Person getPerson(int id) {
		Person person = dao.getById(id);
		if (person == null) {
			throw new NoIdFoundException("Given Person Id " + id + " Is Not Valid");
		}
		return person;
	}

	public List<Person> getAllPersons() {
		return dao.getAllPersons();
	}

	public boolean removePerson(int id) {
		boolean b = dao.deletePerson(id);
		if (b) {
			return true;
		}
		throw new NoIdFoundException("Given Id " + id + " Is Not Valid");
	}

}
