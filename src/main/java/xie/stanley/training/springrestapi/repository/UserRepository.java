package xie.stanley.training.springrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xie.stanley.training.springrestapi.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
