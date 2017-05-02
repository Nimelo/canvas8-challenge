package com.canvas8.repositories;

import com.canvas8.models.CorporateGroup;
import com.canvas8.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    Page<User> findByCorporateGroup(CorporateGroup corporateGroup, Pageable pageable);
}
