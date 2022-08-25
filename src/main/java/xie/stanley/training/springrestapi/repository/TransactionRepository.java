package xie.stanley.training.springrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xie.stanley.training.springrestapi.model.Transaction;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	List<Transaction> findByCreatedDateBetween(LocalDateTime from, LocalDateTime to);
}
