package com.user.service.services;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.service.entities.Hotel;
import com.user.service.entities.Ratings;
import com.user.service.entities.UsersMicro;
import com.user.service.exception.ResourceNotFoundException;
import com.user.service.feign.services.HotelService;
import com.user.service.feign.services.RatingService;
import com.user.service.repository.UserRepository;

@Service
public class UserServiceImpl implements UserServices {

	@Autowired
	private UserRepository userRepository;

//	@Autowired
//	private RestTemplate restTemplate;

	@Autowired
	private HotelService hotelService;

	@Autowired
	private RatingService ratingService;

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public UsersMicro saveUsers(UsersMicro user) {
		String randomUsersid = UUID.randomUUID().toString();
		user.setUserId(randomUsersid);
		return userRepository.save(user);
	}

	@Override
	public List<UsersMicro> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public UsersMicro getUser(String id) {

		UsersMicro user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server " + id));
//		Ratings[] ratingsOfUsers = restTemplate
//				.getForObject("http://RATINGSERVICE/ratings/user/" + user.getUserId(), Ratings[].class);
		Ratings[] ratingsOfUsers = ratingService.getRatingsByUserId(user.getUserId());

		List<Ratings> ratings = Arrays.stream(ratingsOfUsers).toList();

		List<Ratings> ratingList = ratings.stream().map(rating -> {
//			ResponseEntity<Hotel> forEntity = restTemplate
//					.getForEntity("http://HOTELSERVICE/hotel/" + rating.getHotelId(), Hotel.class);
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			rating.setHotel(hotel);
			return rating;}).collect(Collectors.toList());
		
		user.setRatings(ratingList);
		return user;
	}

	@Override
	public void updateUsers(String id, UsersMicro user) {
		UsersMicro existingUser = userRepository.findById(id).get();
		existingUser.setUserName(user.getUserName());
		existingUser.setUserEmail(user.getUserEmail());
		existingUser.setAbout(user.getAbout());

	}

	@Override
	public void deleteUser(String id) {
		userRepository.deleteById(id);
	}

}
