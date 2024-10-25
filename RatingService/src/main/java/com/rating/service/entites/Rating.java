package com.rating.service.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "ratings")
public class Rating {
	@Id
	private String ratingId;

	private String userId;

	private String hotelId;

	private int rating;

	private String feedback;
}
