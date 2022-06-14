package com.ty.hospital.hospitalappboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.hospital.hospitalappboot.dao.MedorderDao;
import com.ty.hospital.hospitalappboot.dto.Medorder;
import com.ty.hospital.hospitalappboot.exception.NoIdFoundException;

@Service
public class MedOrderService {

	@Autowired
	private MedorderDao dao;

	public Medorder saveMedorder(int id, Medorder medorder) {
		Medorder medorder2 = dao.saveMedorder(id, medorder);
		if (medorder2 == null) {
			throw new NoIdFoundException("Given Encounter Id " + id + " Is Not Valid");
		} else {
			return medorder2;
		}
	}

	public Medorder getMedorder(int id) {
		Medorder medorder = dao.getMedorderById(id);
		if (medorder == null) {
			throw new NoIdFoundException("Id Not Found");
		}
		return medorder;
	}

	public List<Medorder> getAllMedorders() {
		return dao.getAllmedorders();
	}

	public boolean removeMedorder(int id) {
		boolean b = dao.deleteMedorder(id);
		if (b) {
			return true;
		} else {
			throw new NoIdFoundException(id + " id Is Invalid");
		}
	}
}
