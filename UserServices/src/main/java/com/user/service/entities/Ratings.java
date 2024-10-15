package com.user.service.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ratings {
	private String ratingId;

	private String userId;

	private String hotelId;

	private int rating;

	private String remark;
}
