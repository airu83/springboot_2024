package kr.co.airu83.springboot_2024.controller;

import kr.co.airu83.springboot_2024.model.User;
import kr.co.airu83.springboot_2024.service.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
public class MainController {

    private final MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping(value ="/test")
    public ResponseEntity<?> test() {
        log.info("MainController -> /test");

        HashMap<String, String> result = new HashMap<>();
        result.put("result", "Success");
        result.put("try Count", "1");

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value ="/path/{value}")
    public ResponseEntity<?> pathTest(@PathVariable(required = true) String value) {
        log.info("MainController -> /pathTest");
        log.info("<<<" + value);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value ="/saveUser")
    public ResponseEntity<?> saveUser(@RequestBody Map<String, Object> params) {
        log.info("MainController -> /saveUser");

        User result = mainService.saveUser(params);

        if(result == null) {
            return new ResponseEntity<>("회원정보 저장에 실패하였습니다.",HttpStatus.OK);
        }
        return new ResponseEntity<>("회원정보 저장에 성공하였습니다.",HttpStatus.OK);
    }

    @PostMapping(value ="/getUser")
    public ResponseEntity<?> getUser(@RequestBody Map<String, Object> params) {
        log.info("MainController -> /getUser");

        Optional<User> result = mainService.getUser(params);

        if(result.isPresent()) {
            log.info("<<<" + result.get().getId() + "<<<" + result.get().getEmail() + "<<<" + result.get().getPassword());
            return new ResponseEntity<>("회원정보 조회에 성공하였습니다.",HttpStatus.OK);
        }
        return new ResponseEntity<>("회원정보 조회에 실패하였습니다." + result, HttpStatus.OK);
    }
}
