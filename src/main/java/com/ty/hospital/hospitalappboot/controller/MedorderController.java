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

import com.ty.hospital.hospitalappboot.dao.MedorderDao;
import com.ty.hospital.hospitalappboot.dto.Encounter;
import com.ty.hospital.hospitalappboot.dto.Medorder;
import com.ty.hospital.hospitalappboot.service.MedOrderService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MedorderController {

	@Autowired
	private MedOrderService medOrderService;

	@ApiOperation(value = "Save The Medorder Details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "Medorder Data Saved"),
			@ApiResponse(code = 405, message = " Bad Request,Data Is Invalid") })

	@PostMapping("/encounter/{encounterid}/medorder")
	public Medorder saveMedorder1(@PathVariable(name = "encounterid") int eid, @RequestBody @Valid Medorder medorder) {

		return medOrderService.saveMedorder(eid, medorder);

	}

	@ApiOperation(value = "Get The Medorder Details By Id", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "Medorder Data Retrived"),
			@ApiResponse(code = 405, message = " Bad Request,Data Is Invalid") })

	@GetMapping("/getmdorder")
	public Medorder getmMedorder(@RequestParam int id) {
		return medOrderService.getMedorder(id);
	}

	@ApiOperation(value = "Get All The Medorder Details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "Medorder Data Retrived"),
			@ApiResponse(code = 405, message = " Bad Request,Data Is Invalid") })

	@GetMapping("/allmedorders")
	public List<Medorder> allmeMedorders() {
		return medOrderService.getAllMedorders();
	}

	@ApiOperation(value = "Removed The Medorder Details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "Medorder Data Removed"),
			@ApiResponse(code = 405, message = " Bad Request,Data Is Invalid") })

	@DeleteMapping("/deletemedorder")
	public void removeMedorder(@RequestParam int id) {
		medOrderService.removeMedorder(id);
	}

	@ApiOperation(value = "Update The Medorder Details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "Medorder Data Updated"),
			@ApiResponse(code = 405, message = " Bad Request,Data Is Invalid") })

	@PutMapping("/updatemedorder")
	public Medorder updateMedorder(@RequestParam int id, @RequestBody Medorder medorder) {

		return null;
	}

}
