package com.ty.hospital.hospitalappboot.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospital.hospitalappboot.dao.HospitalDao;
import com.ty.hospital.hospitalappboot.dto.Hospital;
import com.ty.hospital.hospitalappboot.service.HospitalService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;

	@ApiOperation(value = "Save The Hospital Details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = " Hospital Data Saved"),
			@ApiResponse(code = 405, message = " Bad Request,Data Is Invalid") })
	@PostMapping("/savehospital")
	public Hospital saveHospital(@RequestBody @Valid Hospital hospital) {
		return hospitalService.saveHospital(hospital);
	}

	@ApiOperation(value = "Get The Hospital Details By Id", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = " Hospital Data Retrive"),
			@ApiResponse(code = 405, message = " Bad Request,Data Is Invalid") })

	@GetMapping("/gethospital")
	public Hospital getId(@RequestParam int id) {
		return hospitalService.getHospital(id);
	}

	@ApiOperation(value = "Get All The Hospital Details ", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = " Hospital Data Retrive"),
			@ApiResponse(code = 405, message = " Bad Request,Data Is Invalid") })

	@GetMapping("/allhospital")
	public List<Hospital> allHospitals() {
		return hospitalService.getAllHospitals();
	}

	@ApiOperation(value = "Remove The Hospital Details By Id ", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = " Hospital Data Removed"),
			@ApiResponse(code = 405, message = " Bad Request,Data Is Invalid") })

	@DeleteMapping("/deletehospital")
	public void removeHospital(@RequestParam int id) {
		hospitalService.removeHospital(id);
	}

	@ApiOperation(value = "Update The Hospital Details By Id ", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = " Hospital Data Updated"),
			@ApiResponse(code = 405, message = " Bad Request,Data Is Invalid") })

	@PutMapping("/updatehospital")
	public Hospital updateHospital(@RequestParam int id, @RequestBody Hospital hospital) {

		return hospitalService.updateHospital(id, hospital);
	}

}
