package com.canvas8.services.corporateGroups;

import com.canvas8.models.CorporateGroup;
import com.canvas8.repositories.CorporateGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorporateGroupServiceImpl implements CorporateGroupService {
    @Autowired
    private CorporateGroupRepository corporateGroupRepository;

    @Override
    public List<CorporateGroup> findAll() {
        return corporateGroupRepository.findAll();
    }

    @Override
    public void deleteIfExist(Integer id) {
        if (corporateGroupRepository.exists(id))
            corporateGroupRepository.delete(id);
    }

    @Override
    public void save(CorporateGroup corporateGroup) {
        corporateGroupRepository.save(corporateGroup);
    }

    @Override
    public CorporateGroup findOne(Integer id) {
        CorporateGroup one = corporateGroupRepository.findOne(id);
        return one;
    }
}
