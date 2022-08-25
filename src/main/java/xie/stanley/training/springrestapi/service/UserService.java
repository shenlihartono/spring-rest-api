package xie.stanley.training.springrestapi.service;

import xie.stanley.training.springrestapi.dto.UserDTO;

import java.util.List;

public interface UserService {
	List<UserDTO> findAllUser();
	
	void addUser(UserDTO dto);
}
