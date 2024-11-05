package com.user.service.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ratings {
	private String ratingId;

	private String userId;

	private String hotelId;

	private int rating;

	private String feedback;
	
	private Hotel hotel;
}
