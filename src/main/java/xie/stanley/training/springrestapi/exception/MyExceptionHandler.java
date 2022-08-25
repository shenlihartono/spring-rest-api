package xie.stanley.training.springrestapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleArgumentNotValid(MethodArgumentNotValidException ex) {
		BindingResult bindingResult = ex.getBindingResult();
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();

		List<String> message = new ArrayList<>();
		fieldErrors.forEach(fieldError -> message.add(fieldError.getDefaultMessage()));

		return new ResponseEntity<>(new ApiError(message), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({UserNotFoundException.class, InvalidTransactionDateException.class})
	public ResponseEntity<?> handleUserNotFound(Exception ex) {
		return new ResponseEntity<>(new ApiError(ex.getMessage()), HttpStatus.BAD_REQUEST);
	}

}
