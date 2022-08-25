package xie.stanley.training.springrestapi.dto;

import lombok.Getter;
import lombok.Setter;
import xie.stanley.training.springrestapi.model.TransactionType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateTransactionDTO {
	@Min(value = 1, message = "jumlah uang tidak boleh kosong")
	private long amount;

	@NotNull(message = "tipe transaksi tidak boleh kosong")
	private TransactionType transactionType;

	@Min(value = 1, message = "user id tidak boleh kosong")
	private int userId;
}
