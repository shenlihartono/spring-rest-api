package xie.stanley.training.springrestapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends BaseEntity {

	private String name;

	private LocalDate birthDate;

	private String address;

	@Enumerated(EnumType.STRING)
	private UserType userType;

}
