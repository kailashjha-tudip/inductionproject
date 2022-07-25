package com.tudip.spring_boot_starter.resource;

import com.tudip.spring_boot_starter.dto.UserDTO;
import com.tudip.spring_boot_starter.entity.User;
import com.tudip.spring_boot_starter.service.UserService;

import antlr.collections.List;

import java.awt.print.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserResource {

    @Autowired
    private UserService service;
  
    @GetMapping("/users")
    public List getUser(){
        return (List) service.findAll();
    }

    @GetMapping("/users-by-name")
    public ResponseEntity<UserDTO>  getByName(
        @RequestParam String name
    ){ return service.finByName(name);
    }
	
    @GetMapping("/users")
	public Page<User> getUsers(Pageable pageable ){
		return this.userservice.getUser(pageable);
	}
}
