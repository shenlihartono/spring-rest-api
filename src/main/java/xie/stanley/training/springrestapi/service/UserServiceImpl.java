package xie.stanley.training.springrestapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import xie.stanley.training.springrestapi.dto.UserDTO;
import xie.stanley.training.springrestapi.mapper.UserMapper;
import xie.stanley.training.springrestapi.model.User;
import xie.stanley.training.springrestapi.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final UserMapper userMapper;
	
	@Override
	public List<UserDTO> findAllUser() {
		List<User> users = userRepository.findAll();
		return userMapper.toDTO(users);
	}

	@Override
	public void addUser(UserDTO dto) {

	}
}
