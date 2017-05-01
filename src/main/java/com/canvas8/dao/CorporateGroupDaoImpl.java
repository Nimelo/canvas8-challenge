package com.canvas8.dao;

import com.canvas8.models.CorporateGroup;
import com.canvas8.models.Employee;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("corporateGroupDao")
public class CorporateGroupDaoImpl extends AbstractDao<Integer, CorporateGroup> implements CorporateGroupDao {

    @Override
    public void deleteById(int id) {
        Session session = getSession();
        Object load = session.load(CorporateGroup.class, new Integer(1));
        session.delete(load);
        session.flush();

        Query query = getSession().createQuery("delete from CorporateGroup where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }
}
