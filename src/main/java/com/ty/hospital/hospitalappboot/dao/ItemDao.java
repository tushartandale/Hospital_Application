package com.ty.hospital.hospitalappboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital.hospitalappboot.dto.Item;
import com.ty.hospital.hospitalappboot.dto.Medorder;
import com.ty.hospital.hospitalappboot.exception.NoIdFoundException;
import com.ty.hospital.hospitalappboot.repositery.ItemRepositery;

@Repository
public class ItemDao {

	@Autowired
	private ItemRepositery itemRepositery;

	@Autowired
	private MedorderDao dao;

	public Item saveItem(int id, Item item) {

		Medorder medorder = dao.getMedorderById(id);
		if (medorder != null) {

			item.setMedorder(medorder);
			itemRepositery.save(item);
			return item;
		} else {
			return null;
		}
	}

	public Item getItemById(int id) {
		Optional<Item> item = itemRepositery.findById(id);

		if (item.isEmpty()) {
			return null;
		}
		return item.get();
	}

	public List<Item> getAllitem() {
		return itemRepositery.findAll();
	}

	public boolean deleteItem(int id) {

		Item item = getItemById(id);
		if (item != null) {
			itemRepositery.deleteById(id);
			return true;
		}
		return false;
	}

	public Item updateItem(int id, Item item) {
		Item item2 = getItemById(id);
		if (item2 != null) {
			itemRepositery.save(item);
			return item;
		}
		return null;
	}

}
