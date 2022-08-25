package xie.stanley.training.springrestapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xie.stanley.training.springrestapi.dto.CreateTransactionDTO;
import xie.stanley.training.springrestapi.dto.ViewTransactionDTO;
import xie.stanley.training.springrestapi.service.TransactionService;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class TransactionController {
	private final TransactionService transactionService;

	@PostMapping("/transactions")
	public ResponseEntity<?> createTransaction(@RequestBody @Valid CreateTransactionDTO dto) {
		transactionService.createTransaction(dto);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/transactions")
	public ResponseEntity<?> createTransaction(@RequestParam("start_date") String startDate,
	                                           @RequestParam("end_date") String endDate) {
		List<ViewTransactionDTO> dto = transactionService.viewTransaction(startDate, endDate);

		return ResponseEntity.ok(dto);
	}
}
