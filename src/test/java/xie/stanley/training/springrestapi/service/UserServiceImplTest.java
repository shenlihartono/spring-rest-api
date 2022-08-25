package xie.stanley.training.springrestapi.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import xie.stanley.training.springrestapi.dto.UserDTO;
import xie.stanley.training.springrestapi.exception.UserNotFoundException;
import xie.stanley.training.springrestapi.mapper.UserMapper;
import xie.stanley.training.springrestapi.model.User;
import xie.stanley.training.springrestapi.model.UserType;
import xie.stanley.training.springrestapi.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
	@InjectMocks
	private UserServiceImpl service;

	@Mock
	private UserRepository userRepository;

	@Mock
	private UserMapper userMapper;

	@Test
	void should_FindAllUser_Successfully() {
		List<User> users = new ArrayList<>();
		when(userRepository.findAll()).thenReturn(users);

		List<UserDTO> userDTO = new ArrayList<>();
		when(userMapper.toDTO(users)).thenReturn(userDTO);

		List<UserDTO> actual = service.findAllUser();
		assertThat(actual).isEqualTo(userDTO);
	}

	@Test
	void should_AddUser_Successfully() {
		User user = new User();
		when(userMapper.toModel(any(UserDTO.class))).thenReturn(user);

		service.addUser(new UserDTO());

		verify(userRepository).save(user);
	}

	@Test
	void should_FindUser_Successfully() {
		User user = new User();
		user.setUserType(UserType.LENDER);

		when(userRepository.findById(1)).thenReturn(Optional.of(user));

		User actual = service.findUser(1);
		assertThat(actual.getUserType()).isEqualTo(UserType.LENDER);
	}

	@Test
	void should_FindUser_NotFound() {
		when(userRepository.findById(1)).thenReturn(Optional.empty());

		Exception e = assertThrows(UserNotFoundException.class, () -> service.findUser(1));
		assertThat(e.getMessage()).isEqualTo("user with id: 1 is not found");

	}
}