package xie.stanley.training.springrestapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApiError {
	private List<String> errors;
	
	public ApiError(String error) {
		errors = new ArrayList<>();
		errors.add(error);
	}
}
