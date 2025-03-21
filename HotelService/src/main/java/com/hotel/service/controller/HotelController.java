package com.hotel.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.service.entity.Hotel;
import com.hotel.service.services.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	// create
	@PostMapping()
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
	}

	// getSingle
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getSingleHotelDetails(@PathVariable("hotelId") String id) {
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getSingleHotel(id));
	}

	// getAllHotels
	@GetMapping()
	public ResponseEntity<List<Hotel>> getAllHotelDetails() {
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAll());
	}
}
