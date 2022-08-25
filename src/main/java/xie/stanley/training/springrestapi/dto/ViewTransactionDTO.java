package xie.stanley.training.springrestapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import xie.stanley.training.springrestapi.model.TransactionType;

import java.time.LocalDate;

@Getter
@Setter
public class ViewTransactionDTO {
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate transactionDate;
	private long amount;
	private TransactionType transactionType;
	private String createdBy;
}
