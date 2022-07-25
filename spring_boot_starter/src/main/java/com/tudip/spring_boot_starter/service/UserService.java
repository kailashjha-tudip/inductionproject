package com.tudip.spring_boot_starter.service;


import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.tudip.spring_boot_starter.dto.UserDTO;
import com.tudip.spring_boot_starter.entity.User;

public interface UserService {

	List<UserDTO> findAll();

	ResponseEntity<UserDTO> finByName(String name);
    
	public Page<User> getUsers(Pageable pageable);
    
	//public Page<User> getUsersByName(String name, Pageable pageable);
}
