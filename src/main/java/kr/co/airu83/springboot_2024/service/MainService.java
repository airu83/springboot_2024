package kr.co.airu83.springboot_2024.service;

import kr.co.airu83.springboot_2024.model.User;

import java.util.Map;
import java.util.Optional;

public interface MainService {

    User saveUser(Map<String, Object> params);

    Optional<User> getUser(Map<String, Object> params);
}
