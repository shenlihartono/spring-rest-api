package xie.stanley.training.springrestapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xie.stanley.training.springrestapi.dto.TransactionDTO;
import xie.stanley.training.springrestapi.dto.UserDTO;
import xie.stanley.training.springrestapi.service.TransactionService;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class TransactionController {
	private final TransactionService transactionService;

	@PostMapping("/transactions")
	public ResponseEntity<?> createTransaction(@RequestBody @Valid TransactionDTO dto) {
		transactionService.createTransaction(dto);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
