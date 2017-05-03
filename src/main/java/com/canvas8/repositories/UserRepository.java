package com.canvas8.repositories;

import com.canvas8.models.CorporateGroup;
import com.canvas8.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Integer> {
    String QUERY_FIND_BY_FIRSTNAME_AND_LASTNAME_AND_EMAIL = "SELECT p FROM User p WHERE (LOWER(p.firstName) LIKE LOWER(:firstName) OR LOWER(p.firstName) IS NULL) AND (LOWER(p.secondName) LIKE LOWER(:secondName) OR LOWER(p.secondName) IS NULL) AND (LOWER(p.email) LIKE LOWER(:email) OR LOWER(p.email) IS NULL)";
    User findByEmail(String email);
    Page<User> findByCorporateGroup(CorporateGroup corporateGroup, Pageable pageable);
    @Query(QUERY_FIND_BY_FIRSTNAME_AND_LASTNAME_AND_EMAIL)
    List<User> findByFirstNameAndSecondNameAndEmail(
            @Param("firstName")String firstName,
            @Param("secondName")String secondName,
            @Param("email")String email);
    @Query(QUERY_FIND_BY_FIRSTNAME_AND_LASTNAME_AND_EMAIL + " AND p.corporateGroup.id = :corporateGroupId")
    List<User> findByFirstNameAndSecondNameAndEmailAndCorporateGroupId(
            @Param("firstName")String firstName,
            @Param("secondName")String secondName,
            @Param("email")String email,
            @Param("corporateGroupId")Integer corporateGroupId);
}
