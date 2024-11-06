package com.user.service.feign.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.service.entities.Ratings;

@Service
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
//	@PostMapping("/ratings")
//	Ratings createRating(Ratings rating);

//	Ratings updateRatings();

	@GetMapping("/ratings/user/{userId}")
    Ratings[] getRatingsByUserId(@PathVariable String userId);
}
