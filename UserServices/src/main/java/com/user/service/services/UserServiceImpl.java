package com.user.service.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.service.entities.UsersMicro;
import com.user.service.exception.ResourceNotFoundException;
import com.user.service.repository.UserRepository;

@Service
public class UserServiceImpl implements UserServices {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UsersMicro saveUsers(UsersMicro user) {
		String randomUsersid=UUID.randomUUID().toString();
		user.setUserId(randomUsersid);
		return userRepository.save(user);
	}

	@Override
	public List<UsersMicro> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public UsersMicro getUser(String id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server " + id));
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
