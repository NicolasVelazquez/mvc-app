/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springMVCTutorial.hibernate;

import javax.persistence.EntityManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.springMVCTutorial.config.PersistenceJPAConfig;

public final class HibernateUtils {
    
    private static HibernateUtils instance;
    private EntityManager em;
    
    private HibernateUtils(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(PersistenceJPAConfig.class);
        if (em == null) {
            em = ctx.getBean(LocalContainerEntityManagerFactoryBean.class).getObject().createEntityManager();
        }
    }
    
    public static HibernateUtils getInstance(){
        if(instance == null){
            instance = new HibernateUtils();
        }
        return instance;
    }
    
    public EntityManager getEntityManager(){
        return em;
    }
    
    
}
