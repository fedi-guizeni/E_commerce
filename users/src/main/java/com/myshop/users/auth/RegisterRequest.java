package com.myshop.users.auth;

import com.myshop.users.user.Role;
import lombok.Builder;

@Builder
public record RegisterRequest(
         String username,
         String firstname,
         String lastname,
         String email,
         String password,
         Role role
) {
}
