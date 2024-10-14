package com.user.service.services;

import java.util.List;

import com.user.service.entities.UsersMicro;

public interface UserServices {

	UsersMicro saveUsers(UsersMicro user);

	List<UsersMicro> getAllUsers();

	UsersMicro getUser(String id);

	void updateUsers(String id, UsersMicro user);

	void deleteUser(String id);
}
