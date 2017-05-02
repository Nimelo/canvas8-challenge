package com.canvas8.services.security;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
