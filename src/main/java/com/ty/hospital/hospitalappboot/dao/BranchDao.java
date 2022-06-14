package com.ty.hospital.hospitalappboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.ty.hospital.hospitalappboot.dto.Branch;
import com.ty.hospital.hospitalappboot.dto.Hospital;
import com.ty.hospital.hospitalappboot.exception.NoIdFoundException;
import com.ty.hospital.hospitalappboot.repositery.BranchRepositery;

@Repository
public class BranchDao {

	@Autowired
	BranchRepositery branchRepositery;

	@Autowired
	HospitalDao dao;

	public Branch saveBranch(int hospitalId, Branch branch) {

		Hospital hospital = dao.getById(hospitalId);
		if (hospital == null) {
			return null;
		} else {
			branch.setHospital(hospital);
			return branchRepositery.save(branch);
		}
	}

	public Branch getbyId(int id) {
		Optional<Branch> branch = branchRepositery.findById(id);
		if (branch.isEmpty()) {
			return null;
		}

		return branch.get();
	}

	public Branch updatebBranch(int id, Branch branch) {
		Branch branch2 = getbyId(id);
		if (branch2 != null) {

			branchRepositery.save(branch);
			return branch;
		}
		return null;
	}

	public List<Branch> getAllBranchs() {
		return branchRepositery.findAll();
	}

	public boolean removeBranch(int id) {
		Branch branch = getbyId(id);
		if (branch != null) {
			branchRepositery.deleteById(id);
			return true;
		}
		return false;
	}
}
