package com.tudip.spring_boot_starter.serviceImpl;

import java.awt.print.Pageable;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tudip.spring_boot_starter.dto.UserDTO;
import com.tudip.spring_boot_starter.entity.User;
import com.tudip.spring_boot_starter.enums.ResponseEnum;
import com.tudip.spring_boot_starter.exception.ResourceNotFoundException;
import com.tudip.spring_boot_starter.repository.UserRepository;
import com.tudip.spring_boot_starter.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Override
	public List<UserDTO> findAll() {
		 List<UserDTO> dtos = new ArrayList<>();
	        List<User> users;
			try {
				
				users = userrepo.findAll();
			} catch (Exception e) {
				
				e.printStackTrace();
			}

	        if (CollectionUtils.isEmpty(users)){
	            return null;
	        }

	        for ( User user: users) {

	           dtos.add( new UserDTO(user.getId(), user.getName(), user.getPhoneno(), user.getEmailId(), user.getCityname()));

	       }

	        return dtos;
	}

	@Override
	public ResponseEntity<UserDTO> finByName(String name) {
		  public ResponseEntity<UserDTO> findByName(String name) {

		        ResponseEntity<UserDTO> responseDTOResponseEntity = null;

		        UserDTO responseDTO = null;

		        if (User.isEmpty(name)){

		            responseDTO = new UserDTO(ResponseEnum.BAD_REQUEST_PARAMETER);

		            responseDTOResponseEntity =  ResponseEntity.badRequest().body(responseDTO);
		        }else{

		            try{

		                List<UserDTO> dtos = new ArrayList<>();
		                List<User> users = UserRepository.findByName(name);

		                if (User.isEmpty(users)){

		                    responseDTO = new UserDTO(ResponseEnum.NOT_FOUND);

		                    responseDTOResponseEntity = ResponseEntity.badRequest().body(responseDTO);
		                }else{

		                    for ( User user: users) {

		                        dtos.add( new UserDTO(user.getId(), user.getName(), user.getPhoneno(), user.getEmailId(), user.getCityname()) );

		                   }

		                    responseDTO = new UserDTO(ResponseEnum.SUCCESS);

		                    responseDTO.setDataList(dtos);

		                    responseDTOResponseEntity = ResponseEntity.ok(responseDTO);

		                }



		            }catch (Exception e){


		                responseDTO = new UserDTO(ResponseEnum.INTERNAL_SERVER_ERROR);

		                responseDTOResponseEntity = ResponseEntity.internalServerError().body(responseDTO);
		            }

		        }



		        return responseDTOResponseEntity;
		    }
	}

	@Override
	public Page<User> getUsers(Pageable pageable) {
	//	Response<User> response = new Response<User>(null, null, null);
		try {
			Page<User> users = UserDTO.findAll(pageable);
			if (users != null) {
				return users;

			
			} else {
				throw new ResourceNotFoundException("User record not found");
			}
		} catch (Exception e) {
		
			throw new ResourceNotFoundException("User record not found");
		}
	//	return response;
	}

	
	
	
	
}
