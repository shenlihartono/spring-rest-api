package xie.stanley.training.springrestapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;

	private LocalDate birthDate;

	private String address;

	@Enumerated(EnumType.STRING)
	private UserType userType;

}
