package xie.stanley.training.springrestapi.dto;

import lombok.Getter;
import lombok.Setter;
import xie.stanley.training.springrestapi.model.UserType;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDTO {
	private String name;

	private LocalDateTime birthDate;

	private String address;

	private UserType userType;
}
