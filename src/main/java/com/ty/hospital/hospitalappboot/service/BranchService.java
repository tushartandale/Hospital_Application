package com.ty.hospital.hospitalappboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.hospital.hospitalappboot.dao.BranchDao;
import com.ty.hospital.hospitalappboot.dto.Branch;
import com.ty.hospital.hospitalappboot.exception.NoIdFoundException;

@Service
public class BranchService {

	@Autowired
	private BranchDao branchDao;

	public Branch saveBranch(int id, Branch branch) {
		Branch branch2 = branchDao.saveBranch(id, branch);

		if (branch2 == null) {
			throw new NoIdFoundException("Given Hospital Id " + id + " Is Not Found");
		}
		return branch2;
	}

	public Branch getBranch(int id) {
		Branch branch = branchDao.getbyId(id);
		if (branch == null) {
			throw new NoIdFoundException("Given Branch Id " + id + " Is Not Valid");
		}
		return branch;
	}

	public List<Branch> getAllBranchs() {
		return branchDao.getAllBranchs();
	}

	public boolean removeBranch(int id) {
		boolean b = branchDao.removeBranch(id);
		if (b) {
			return b;
		}
		throw new NoIdFoundException("Branch Id " + id + " Is Not Match");
	}

}
