package kr.co.airu83.springboot_2024.service.impl;

import kr.co.airu83.springboot_2024.model.User;
import kr.co.airu83.springboot_2024.repository.UserRepository;
import kr.co.airu83.springboot_2024.service.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
public class MainServiceImpl implements MainService {

    private final UserRepository userRepository;

    public MainServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public User saveUser(Map<String, Object> params) {
        User user = new User();
        user.setEmail(String.valueOf(params.get("email")));
        user.setPassword(String.valueOf(params.get("password")));
        try {
            return userRepository.save(user);
        } catch(Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return null;
        }
    }

    @Override
    public Optional<User> getUser(Map<String, Object> params) {

        User user = new User();
        user.setId(Integer.parseInt(String.valueOf(params.get("id"))));

        try{
            return userRepository.findById(user.getId());
        }catch(Exception e) {
            return null;
        }
    }
}
