package com.canvas8.services.user;

import com.canvas8.models.CorporateGroup;
import com.canvas8.models.Role;
import com.canvas8.repositories.RoleRepository;
import com.canvas8.repositories.UserRepository;
import com.canvas8.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findOne(Role.ROLE_USER_ID);
        Set<Role> roles = new HashSet<>();
        roles.add(userRole);

        user.setRoles(roles);
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByEmail(username);
    }

    @Override
    public Page<User> findByCorporateGroupId(CorporateGroup id, Pageable pageable) {
        return userRepository.findByCorporateGroup(id, pageable);
    }

    @Override
    public void remove(Integer userId) {
        if(userRepository.exists(userId)){
            userRepository.delete(userId);
        }
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findOne(id);
    }
}
