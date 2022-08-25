package xie.stanley.training.springrestapi.mapper;

import org.mapstruct.Mapper;
import xie.stanley.training.springrestapi.dto.UserDTO;
import xie.stanley.training.springrestapi.model.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
	User toModel(UserDTO dto);

	List<UserDTO> toDTO(List<User> model);
}
