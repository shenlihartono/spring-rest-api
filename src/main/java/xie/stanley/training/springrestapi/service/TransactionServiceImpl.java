package xie.stanley.training.springrestapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import xie.stanley.training.springrestapi.dto.CreateTransactionDTO;
import xie.stanley.training.springrestapi.dto.ViewTransactionDTO;
import xie.stanley.training.springrestapi.exception.InvalidTransactionDateException;
import xie.stanley.training.springrestapi.mapper.TransactionMapper;
import xie.stanley.training.springrestapi.model.Transaction;
import xie.stanley.training.springrestapi.model.User;
import xie.stanley.training.springrestapi.repository.TransactionRepository;
import xie.stanley.training.springrestapi.util.DateUtil;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {
	private final TransactionRepository transactionRepository;
	private final UserService userService;
	private final DateUtil dateUtil;
	private final TransactionMapper transactionMapper;

	@Override
	public void createTransaction(CreateTransactionDTO dto) {
		User user = userService.findUser(dto.getUserId());

		Transaction transaction = transactionMapper.toModel(dto);
		transaction.setUser(user);
		transactionRepository.save(transaction);
	}

	@Override
	public List<ViewTransactionDTO> viewTransaction(String startDate, String endDate) {
		LocalDate from = dateUtil.parseDate(startDate);
		LocalDate to = dateUtil.parseDate(endDate);

		validateDate(from, to);

		List<Transaction> transactions = transactionRepository.findByTransactionDateBetween(from, to);
		return transactionMapper.toDTO(transactions);
	}

	@Override
	public List<ViewTransactionDTO> viewTransaction(int userId) {
		User user = userService.findUser(userId);
		
		List<Transaction> transactions = transactionRepository.findByUserOrderByIdDesc(user);
		return transactionMapper.toDTO(transactions);
	}

	private void validateDate(LocalDate from, LocalDate to) {
		if (to.isBefore(from)) {
			throw new InvalidTransactionDateException();
		}
	}

}
