package com.canvas8.services.corporateGroups;

import com.canvas8.models.CorporateGroup;

import java.util.List;

public interface CorporateGroupService {
    List<CorporateGroup> findAll();

    void deleteIfExist(Integer id);

    void save(CorporateGroup corporateGroup);

    CorporateGroup findOne(Integer id);
}
