package com.tudip.spring_boot_starter.dto;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;

import com.tudip.spring_boot_starter.entity.User;
import com.tudip.spring_boot_starter.enums.ResponseEnum;

public class UserDTO {
	
private long id;
private String name;
private long emailId;
private long phoneno;
private String cityname;
public UserDTO(long id, String name, long emailId, long phoneno, String cityname) {
	super();
	this.id = id;
	this.name = name;
	this.emailId = emailId;
	this.phoneno = phoneno;
	this.cityname = cityname;
}
public UserDTO(ResponseEnum badRequestParameter) {
	// TODO Auto-generated constructor stub
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getEmailId() {
	return emailId;
}
public void setEmailId(long emailId) {
	this.emailId = emailId;
}
public long getPhoneno() {
	return phoneno;
}
public void setPhoneno(long phoneno) {
	this.phoneno = phoneno;
}
public String getCityname() {
	return cityname;
}
public void setCityname(String cityname) {
	this.cityname = cityname;
}
public void setDataList(List<UserDTO> dtos) {

	
}
public static Page<User> findAll(Pageable pageable) {
	// TODO Auto-generated method stub
	return null;
}



}

  

