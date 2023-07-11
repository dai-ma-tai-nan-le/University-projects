package com.ljp.dao;

import java.util.List;

import com.ljp.entity.User;

public interface UserDAO {

    void save(User transientInstance);

	 void delete(User persistentInstance);

	 User findById(java.lang.Integer id);

	 List findByExample(User instance);

	 List findByProperty(String propertyName, Object value);

	List findByUsername(Object username);

	List findByPassword(Object password);

	 List findByEmail(Object email);

	 List findAll();

	 User merge(User detachedInstance);

	void attachDirty(User instance);

	 void attachClean(User instance);

}