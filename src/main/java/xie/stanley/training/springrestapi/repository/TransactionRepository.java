package xie.stanley.training.springrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xie.stanley.training.springrestapi.model.Transaction;
import xie.stanley.training.springrestapi.model.User;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	List<Transaction> findByTransactionDateBetween(LocalDate from, LocalDate to);
	
	List<Transaction> findByUserOrderByIdDesc(User user);
}
