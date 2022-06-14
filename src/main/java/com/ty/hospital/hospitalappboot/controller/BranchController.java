package com.ty.hospital.hospitalappboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospital.hospitalappboot.dao.BranchDao;
import com.ty.hospital.hospitalappboot.dto.Branch;
import com.ty.hospital.hospitalappboot.dto.Hospital;
import com.ty.hospital.hospitalappboot.service.BranchService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BranchController {

	@Autowired
	private BranchService branchService;

	@ApiOperation(value = "Save The Branch Details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = " Branch Data Saved"),
			@ApiResponse(code = 405, message = " Bad Request,Data Is Invalid") })

	@PostMapping("/hospital/{hospitalid}/branch")
	public Branch saveBranch(@PathVariable(name = "hospitalid") int id, @RequestBody @Valid Branch branch) {
		return branchService.saveBranch(id, branch);
	}

	@ApiOperation(value = "Get The Branch Details By Id", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = " Branch Data Retrive"),
			@ApiResponse(code = 405, message = " Bad Request,Data Is Invalid") })

	@GetMapping("branch/{branchid}")
	public Branch getBranch(@PathVariable(name = "branchid") int bid) {
		return branchService.getBranch(bid);
	}

	@ApiOperation(value = "Get All The Branch Details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = " Branch Data Retrive"),
			@ApiResponse(code = 405, message = " Bad Request,Data Is Invalid") })

	@GetMapping("/allbranches")
	public List<Branch> allBranchs() {
		return branchService.getAllBranchs();
	}

	@ApiOperation(value = "Remove The Branch Details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = " Branch Data Removed"),
			@ApiResponse(code = 405, message = " Bad Request,Data Is Invalid") })

	@DeleteMapping("/deletebranch")
	public void removeBranch(@RequestParam int id) {
		branchService.removeBranch(id);
	}

	@ApiOperation(value = "Update The Branch Details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "Branch Data Updated"),
			@ApiResponse(code = 405, message = " Bad Request,Data Is Invalid") })

	@PutMapping("/updatebranchh")
	public Branch updateBranch(@RequestParam int id, @RequestBody Branch branch) {

		return null;
	}

}
