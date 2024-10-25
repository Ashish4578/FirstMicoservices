package com.hotel.service.services;

import java.util.List;

import com.hotel.service.entity.Hotel;

public interface HotelService {

	// create
	Hotel create(Hotel hotel);

	// getAll
	List<Hotel> getAll();

	// getSingle
	Hotel getSingleHotel(String id);

	// update
	Hotel updateHotelDetails(String id, Hotel hotel);

	// delete
	void deleteHotelById(String id);
}
