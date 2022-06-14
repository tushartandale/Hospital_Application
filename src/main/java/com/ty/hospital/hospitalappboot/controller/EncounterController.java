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
import com.ty.hospital.hospitalappboot.dao.EncounterDao;
import com.ty.hospital.hospitalappboot.dao.PersonDao;
import com.ty.hospital.hospitalappboot.dto.Branch;
import com.ty.hospital.hospitalappboot.dto.Encounter;
import com.ty.hospital.hospitalappboot.service.EncounterService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EncounterController {

	@Autowired
	private EncounterService encounterService;

	@ApiOperation(value = "Save The Encounter Details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "Encounter Data Saved"),
			@ApiResponse(code = 405, message = " Bad Request,Data Is Invalid") })

	@PostMapping("/branch/{branchid}/person/{personid}/encounter")
	public Encounter saveEncounter(@PathVariable(name = "branchid") int bid, @PathVariable(name = "personid") int pid,
			@RequestBody @Valid Encounter encounter) {
		return encounterService.saveEncounter(bid, pid, encounter);
	}

	@ApiOperation(value = "Get The Encounter Details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "Encounter Data Retrived"),
			@ApiResponse(code = 405, message = " Bad Request,Data Is Invalid") })

	@GetMapping("/getencounter")
	public Encounter getEncounter(@RequestParam int id) {

		return encounterService.getEncounter(id);

	}

	@ApiOperation(value = "Get All The Encounter Details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "Encounter Data Retrived"),
			@ApiResponse(code = 405, message = " Bad Request,Data Is Invalid") })

	@GetMapping("/allencounters")
	public List<Encounter> allEncounters() {
		return encounterService.getAllEncounters();
	}

	@ApiOperation(value = "Removed The Encounter Details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "Encounter Data Retrived"),
			@ApiResponse(code = 405, message = " Bad Request,Data Is Invalid") })

	@DeleteMapping("/deleteencounter")
	public void removeEncounter(@RequestParam int id) {
		encounterService.removeEncounter(id);
	}

	@ApiOperation(value = "Update The Encounter Details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "Encounter Data Updated"),
			@ApiResponse(code = 405, message = " Bad Request,Data Is Invalid") })

	@PutMapping("/updateEncounter")
	public Encounter updateEncounter(@RequestParam int id, @RequestBody Encounter encounter) {

		return null;
	}

}
