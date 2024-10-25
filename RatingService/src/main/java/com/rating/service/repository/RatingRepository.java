package com.rating.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rating.service.entites.Rating;

public interface RatingRepository extends JpaRepository<Rating, String> {

	// finder method for searching by User id
	List<Rating> findByUserId(String userId);

	// finder method for searching by Hotel id
	List<Rating> findByHotelId(String hotelId);
}
