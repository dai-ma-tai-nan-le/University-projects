package com.ljp.bizimpl;

import java.util.List;

import com.ljp.biz.UserBIZ;
import com.ljp.dao.UserDAO;
import com.ljp.entity.User;

public class UserBIZImpl implements UserBIZ {

	UserDAO userDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public void save(User transientInstance) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User persistentInstance) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findByExample(User instance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findByUsername(Object username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findByPassword(Object password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findByEmail(Object email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return userDAO.findAll();
	}

	@Override
	public User merge(User detachedInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void attachDirty(User instance) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attachClean(User instance) {
		// TODO Auto-generated method stub

	}

}
