package ru.otus.library2.repository;

import org.springframework.data.repository.CrudRepository;
import ru.otus.library2.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
  User findByUsername(String username);

}
