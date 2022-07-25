package com.tudip.spring_boot_starter.repository;

import com.tudip.spring_boot_starter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long > {

    @Query("select u from User u where name =?1")
	static
    List<User> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
    default List<User> findAll(long Id){
    	return null;
    }
    
}
