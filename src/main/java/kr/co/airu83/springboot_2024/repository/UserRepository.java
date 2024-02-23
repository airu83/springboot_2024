package kr.co.airu83.springboot_2024.repository;

import kr.co.airu83.springboot_2024.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
