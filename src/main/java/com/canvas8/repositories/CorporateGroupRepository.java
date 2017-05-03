package com.canvas8.repositories;

import com.canvas8.models.CorporateGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorporateGroupRepository extends JpaRepository<CorporateGroup, Integer> {
    CorporateGroup findByName(String name);
}
