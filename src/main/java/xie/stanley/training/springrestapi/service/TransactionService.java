package xie.stanley.training.springrestapi.service;

import xie.stanley.training.springrestapi.dto.CreateTransactionDTO;
import xie.stanley.training.springrestapi.dto.ViewTransactionDTO;

import java.util.List;

public interface TransactionService {
	void createTransaction(CreateTransactionDTO dto);

	List<ViewTransactionDTO> viewTransaction(String startDate, String endDate);

	List<ViewTransactionDTO> viewTransaction(int userId);
}
