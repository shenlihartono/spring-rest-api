package xie.stanley.training.springrestapi.exception;

public class InvalidTransactionDateException extends RuntimeException {
	@Override
	public String getMessage() {
		return "mohon periksa kembali tanggal start_date dan end_date";
	}
}
