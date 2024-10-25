package com.rating.service.services;

import java.util.List;

import com.rating.service.entites.Rating;

public interface RatingServices {

	// create
	Rating create(Rating rating);

	// get all ratings
	List<Rating> getRating();

	// get all by user id
	List<Rating> getRatingByUserId(String userId);

	// get all by hotel
	List<Rating> getRatingByHotelId(String hotelId);
}
