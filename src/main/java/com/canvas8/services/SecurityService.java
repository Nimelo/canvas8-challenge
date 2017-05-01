package com.canvas8.services;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
