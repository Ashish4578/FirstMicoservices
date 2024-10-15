package com.user.service.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "micro_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsersMicro {

	@Id
	private String userId;

	@Column(length = 10)
	private String userName;

	@Column(length = 30)
	private String userEmail;

	@Column(length = 100)
	private String about;

	@Transient
	private List<Ratings> ratings;
}
