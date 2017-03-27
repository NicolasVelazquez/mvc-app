/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springMVCTutorial.dao;

import java.io.Serializable;
import java.util.List;

import com.springMVCTutorial.exception.ApplicationException;

public interface GenericDAO<T> {
    
    List findAll(Class clase) throws ApplicationException;
    void save(Object t);
    Object update(Object t);
    Serializable findById(Class clase, Long id);
}
