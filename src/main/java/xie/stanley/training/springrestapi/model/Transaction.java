package xie.stanley.training.springrestapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")
@Getter
@Setter
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private LocalDate transactionDate; 
	
	private long amount;

	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;

	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
}
