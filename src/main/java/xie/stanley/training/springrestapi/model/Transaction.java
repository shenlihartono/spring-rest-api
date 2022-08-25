package xie.stanley.training.springrestapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Getter
@Setter
public class Transaction extends BaseEntity {
	
	private long amount;

	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;

	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
}
