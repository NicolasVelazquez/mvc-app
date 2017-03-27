
package com.springMVCTutorial.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.springMVCTutorial.exception.ApplicationException;
import com.springMVCTutorial.hibernate.HibernateUtils;


public abstract class GenericDAOImpl{

    protected static EntityManager entityManager = getEntityManager();

    private static EntityManager getEntityManager() {
        HibernateUtils hibernateUtils = HibernateUtils.getInstance();
        return hibernateUtils.getEntityManager();
    }

    public List findAll(Class clase) throws ApplicationException {
        Query query;
        query = entityManager.createQuery(" FROM " + clase.getName());
        return query.getResultList();
    }
    
    public Serializable findById(Class clase, Long id){
        Query query;
        query = entityManager.createQuery(" FROM " + clase.getName() + " as c where c.id = :id");
        query.setParameter("id", id);
        try{
            return (Serializable) query.getSingleResult();
        }catch(NoResultException ex){
            return null;
        }
    }

    public Object update(Object t) {
        return entityManager.merge(t);
    }

    public void save(Object t) {
        entityManager.persist(t);
        entityManager.flush();
    }
    
}
