package com.canvas8.services;

import com.canvas8.models.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
