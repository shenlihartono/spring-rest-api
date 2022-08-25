package xie.stanley.training.springrestapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import xie.stanley.training.springrestapi.model.TransactionType;

import java.time.LocalDateTime;

@Getter
@Setter
public class ViewTransactionDTO {
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime transactionDate;
	private long amount;
	private TransactionType transactionType;
	private String createdBy;
}
