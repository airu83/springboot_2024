package kr.co.airu83.springboot_2024.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping(value ="/test")
    public ResponseEntity<?> test() {
        return new ResponseEntity<>("test OK!!", HttpStatus.OK);
    }
}
