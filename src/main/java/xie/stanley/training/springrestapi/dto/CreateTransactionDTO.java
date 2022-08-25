package xie.stanley.training.springrestapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import xie.stanley.training.springrestapi.model.TransactionType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class CreateTransactionDTO {
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "tanggal transaksi tidak boleh kosong")
	private LocalDate transactionDate;
	
	@Min(value = 1, message = "jumlah uang tidak boleh kosong")
	private long amount;

	@NotNull(message = "tipe transaksi tidak boleh kosong")
	private TransactionType transactionType;

	@Min(value = 1, message = "user id tidak boleh kosong")
	private int userId;
}
