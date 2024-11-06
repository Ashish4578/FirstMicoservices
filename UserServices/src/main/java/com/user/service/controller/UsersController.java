package com.user.service.controller;

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

import com.user.service.entities.UsersMicro;
import com.user.service.services.UserServices;

import ch.qos.logback.classic.Logger;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UserServices userServices;

	@PostMapping
	public ResponseEntity<UsersMicro> createUser(@RequestBody UsersMicro user) {
		UsersMicro users1 = userServices.saveUsers(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(users1);
	}

	public ResponseEntity<UsersMicro> ratingHotelFallBackMethod(String id, Exception ex) {
		UsersMicro user = UsersMicro.builder().userId("demo circuit breaker").userName("circuitdummy")
				.about("circuitdummy method is written").userEmail("circuitdummy@random.com").build();
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	public ResponseEntity<UsersMicro> ratingHotelFallBackRetryMethod(String id, Exception ex) {
		UsersMicro user = UsersMicro.builder().userId("demo retry breaker").userName("retry dummy")
				.about("retry dummy method is written").userEmail("retrydummy@random.com").build();
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	int count = 0;

	@GetMapping("/{id}")
	@CircuitBreaker(name = "hotelRatingBreaker", fallbackMethod = "ratingHotelFallBackMethod")
	@Retry(name = "hotelRatingRetry", fallbackMethod = "ratingHotelFallBackRetryMethod")
	public ResponseEntity<UsersMicro> getUserById(@PathVariable String id) {
		UsersMicro user = userServices.getUser(id);
		System.out.println(count);
		count++;
		return ResponseEntity.ok(user);
	}

	@GetMapping
	public ResponseEntity<List<UsersMicro>> getAllUsers() {
		List<UsersMicro> allUsers = userServices.getAllUsers();
		return ResponseEntity.ok(allUsers);
	}
}
