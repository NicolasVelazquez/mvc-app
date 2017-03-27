/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springMVCTutorial.service;

import java.util.List;
import javax.persistence.EntityManager;

import com.springMVCTutorial.exception.ApplicationException;
import com.springMVCTutorial.hibernate.HibernateUtils;

public abstract class GenericService {

    protected static EntityManager entityManager = getEntityManager();

    private static EntityManager getEntityManager() {
       HibernateUtils hibernateUtils = HibernateUtils.getInstance();
        return hibernateUtils.getEntityManager();
    }

    public abstract List findAll() throws ApplicationException;

}
