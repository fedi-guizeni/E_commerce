package com.myshop.users;


import com.myshop.users.auth.AuthenticationService;
import com.myshop.users.auth.RegisterRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.myshop.users.user.Role.ADMIN;
import static com.myshop.users.user.Role.MANAGER;

@SpringBootApplication
public class UsersApplication {
    public static void main(String[] args) {

        SpringApplication.run(UsersApplication.class, args);



    }
    @Bean
    public CommandLineRunner commandLineRunner(
            AuthenticationService  service
    ) {
        return args -> {
            var admin = RegisterRequest.builder()
                    .username("Admin")
                    .firstname("Admin")
                    .lastname("Admin")
                    .email("admin@mail.com")
                    .password("password")
                    .role(ADMIN)
                    .build();
            System.out.println("Admin token: " + service.register(admin).getAccessToken());

            var manager = RegisterRequest.builder()
                    .username("manager")
                    .firstname("manager")
                    .lastname("manager")
                    .email("manager@mail.com")
                    .password("password")
                    .role(MANAGER)
                    .build();
            System.out.println("Manager token: " + service.register(manager).getAccessToken());

        };
}
}