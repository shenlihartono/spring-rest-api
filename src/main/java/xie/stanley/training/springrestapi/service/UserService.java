package xie.stanley.training.springrestapi.service;

import xie.stanley.training.springrestapi.dto.UserDTO;
import xie.stanley.training.springrestapi.model.User;

import java.util.List;

public interface UserService {
	List<UserDTO> findAllUser();
	
	void addUser(UserDTO dto);
	
	User findUser(int id);
}
