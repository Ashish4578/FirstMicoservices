package com.hotel.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.service.services.HotelService;

@RestController
public class HotelController {

	@Autowired
	private HotelService hotelService;
}
