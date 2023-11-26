package com.myshop.users.auth;

public record AuthenticationRequest(String username,
                                    String password
) {
}
