package com.user.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.service.entities.UsersMicro;

public interface UserRepository extends JpaRepository<UsersMicro, String>{

}
