package xie.stanley.training.springrestapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import xie.stanley.training.springrestapi.dto.TransactionDTO;
import xie.stanley.training.springrestapi.model.Transaction;
import xie.stanley.training.springrestapi.model.User;
import xie.stanley.training.springrestapi.repository.TransactionRepository;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {
	private final TransactionRepository transactionRepository;
	private final UserService userService;

	@Override
	public void createTransaction(TransactionDTO dto) {
		User user = userService.findUser(dto.getUserId());

		Transaction transaction = new Transaction();
		transaction.setAmount(dto.getAmount());
		transaction.setTransactionType(dto.getTransactionType());
		transaction.setUser(user);
		transactionRepository.save(transaction);
	}

}
