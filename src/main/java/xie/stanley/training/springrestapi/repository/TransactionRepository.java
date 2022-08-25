package xie.stanley.training.springrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xie.stanley.training.springrestapi.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
