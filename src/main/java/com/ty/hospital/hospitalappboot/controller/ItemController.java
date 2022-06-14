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

import com.ty.hospital.hospitalappboot.dao.ItemDao;
import com.ty.hospital.hospitalappboot.dto.Encounter;
import com.ty.hospital.hospitalappboot.dto.Item;
import com.ty.hospital.hospitalappboot.service.ItemService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;

	@ApiOperation(value = "Save The Item Details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "Item Data Saved"),
			@ApiResponse(code = 405, message = " Bad Request,Data Is Invalid") })

	@PostMapping("/medorder/{orderid}/item")
	public Item saveItem1(@PathVariable(name = "orderid") int mid, @RequestBody @Valid Item item) {

		return itemService.saveItem(mid, item);

	}

	@ApiOperation(value = "Get The Item Details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "Item Data Retrived"),
			@ApiResponse(code = 405, message = " Bad Request,Data Is Invalid") })

	@GetMapping("/getitem")
	public Item getItem(@RequestParam int id) {

		return itemService.getItem(id);

	}

	@ApiOperation(value = "Get All The Item Details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "Item Data Retriveed"),
			@ApiResponse(code = 405, message = " Bad Request,Data Is Invalid") })

	@GetMapping("/allitem")
	public List<Item> allItem() {
		return itemService.getAllItem();
	}

	@ApiOperation(value = "Remove The Item Details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "Item Data Removed"),
			@ApiResponse(code = 405, message = " Bad Request,Data Is Invalid") })

	@DeleteMapping("/deleteitem")
	public void removeItem(@RequestParam int id) {
		itemService.removeItem(id);
	}

	@ApiOperation(value = "Update The Item Details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "Item Data Updated"),
			@ApiResponse(code = 405, message = " Bad Request,Data Is Invalid") })

	@PutMapping("/updateItem")
	public Item updateEncounter(@RequestParam int id, @RequestBody Item item) {

		return null;
	}

}
