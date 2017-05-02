package com.canvas8.services.corporateGroups;

import com.canvas8.models.CorporateGroup;

import java.util.List;

/**
 * Created by mrnimelo on 02/05/17.
 */
public interface CorporateGroupService {
    List<CorporateGroup> findAll();
    void deleteIfExist(Integer id);
    void save(CorporateGroup corporateGroup);
    CorporateGroup findOne(Integer id);
}
