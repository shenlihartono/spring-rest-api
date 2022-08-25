package xie.stanley.training.springrestapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private LocalDateTime createdDate;
	
	private String name;
	
	private LocalDateTime birthDate;
	
	private String address;

	@Enumerated(EnumType.STRING)
	private UserType userType;
	
}
