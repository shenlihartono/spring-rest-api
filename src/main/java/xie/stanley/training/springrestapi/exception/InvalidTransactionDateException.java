package xie.stanley.training.springrestapi.exception;

public class InvalidTransactionDateException extends RuntimeException {
	@Override
	public String getMessage() {
		return "please check the start_date and end_date";
	}
}
