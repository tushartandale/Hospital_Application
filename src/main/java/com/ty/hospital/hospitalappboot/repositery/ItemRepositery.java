package com.ty.hospital.hospitalappboot.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hospital.hospitalappboot.dto.Item;

public interface ItemRepositery extends JpaRepository<Item, Integer> {

}
