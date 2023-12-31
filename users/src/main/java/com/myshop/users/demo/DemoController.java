package com.myshop.users.demo;


import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/authDemo")
@Hidden
public class DemoController {

    @GetMapping
    public ResponseEntity<String> test (){
        return ResponseEntity.ok("hello world from demo");
    }
}
