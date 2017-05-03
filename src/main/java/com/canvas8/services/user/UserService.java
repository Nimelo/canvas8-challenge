package com.canvas8.services.user;

import com.canvas8.models.CorporateGroup;
import com.canvas8.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    void save(User user);

    User findByUsername(String username);

    Page<User> findByCorporateGroupId(CorporateGroup id,
                                      Pageable pageable);

    void remove(Integer userId);

    User findById(Integer id);

    List<User> findByFirstNameAndSecondNameAndEmailAndCorporateGroupId(
            String firstName,
            String secondName,
            String email,
            Integer corporateGroupId);
}
