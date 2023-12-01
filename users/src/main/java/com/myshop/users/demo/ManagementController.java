package com.myshop.users.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/management")
public class ManagementController {

    @GetMapping
    public ResponseEntity<String> get (){
        return ResponseEntity.ok("GET :: ManagementController");
    }

    @PostMapping
    public ResponseEntity<String> post (){
        return ResponseEntity.ok("POST :: ManagementController");
    }

    @DeleteMapping
    public ResponseEntity<String> delete (){
        return ResponseEntity.ok("DELETE :: ManagementController");
    }

    @PutMapping 
    public ResponseEntity<String> put (){
        return ResponseEntity.ok("PUT :: ManagementController");
    }

}
