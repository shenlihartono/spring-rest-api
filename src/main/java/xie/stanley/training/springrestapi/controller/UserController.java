package xie.stanley.training.springrestapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xie.stanley.training.springrestapi.dto.UserDTO;
import xie.stanley.training.springrestapi.service.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {
	private final UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<?> getAllUser() {
		List<UserDTO> users = userService.findAllUser();
		return ResponseEntity.ok(users);
	}
	
}
