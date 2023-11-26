package com.myshop.users.auth;

public record RegisterRequest(
         String username,
         String firstname,
         String lastname,
         String email,
         String password
) {
}
