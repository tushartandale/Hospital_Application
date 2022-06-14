package com.ty.hospital.hospitalappboot.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospital.hospitalappboot.dao.PersonDao;
import com.ty.hospital.hospitalappboot.dto.Person;
import com.ty.hospital.hospitalappboot.service.PersonService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	@ApiOperation(value = "Save The Person Details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = " Person Data Saved"),
			@ApiResponse(code = 405, message = " Bad Request,Data Is Invalid") })

	@PostMapping("/person")
	public Person savePerson(@RequestBody @Valid Person person) {

		return personService.savePerson(person);

	}

	@ApiOperation(value = "Get The Person Details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "Person Data Retrive"),
			@ApiResponse(code = 405, message = " Bad Request,Data Is Invalid") })

	@GetMapping("/person")
	public Person getId(@RequestParam int id) {
		return personService.getPerson(id);
	}

	@ApiOperation(value = "Get All The Person Details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "Person Data Retrive"),
			@ApiResponse(code = 405, message = " Bad Request,Data Is Invalid") })

	@GetMapping("/allpersons")
	public List<Person> getAll() {
		return personService.getAllPersons();
	}

	@ApiOperation(value = "Remove The Person Details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "Person Data Removed"),
			@ApiResponse(code = 405, message = " Bad Request,Data Is Invalid") })

	@DeleteMapping("/person")
	public void delete(@RequestParam int id) {
		personService.removePerson(id);
	}

	@ApiOperation(value = "Update The Person Details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "Person Data Updated"),
			@ApiResponse(code = 405, message = " Bad Request,Data Is Invalid") })

	@PostMapping("/updateperson")
	public Person updatePerson(@RequestParam int id, @RequestBody Person person) {
		return null;
	}

}
