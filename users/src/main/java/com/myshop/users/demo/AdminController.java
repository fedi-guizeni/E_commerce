package com.myshop.users.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @GetMapping
    public ResponseEntity<String> get (){
        return ResponseEntity.ok("GET :: AdminController");
    }

    @PostMapping
    public ResponseEntity<String> post (){
        return ResponseEntity.ok("POST :: AdminController");
    }

    @DeleteMapping
    public ResponseEntity<String> delete (){
        return ResponseEntity.ok("DELETE :: AdminController");
    }

    @PutMapping
    public ResponseEntity<String> put (){
        return ResponseEntity.ok("PUT :: AdminController");
    }

}
