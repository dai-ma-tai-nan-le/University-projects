package com.ljp.daoimpl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ljp.dao.UserDAO;
import com.ljp.entity.User;

/**
 * A data access object (DAO) providing persistence and search support for User
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.ljp.daoimpl.User
 * @author MyEclipse Persistence Tools
 */

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {
	private static final Log log = LogFactory.getLog(UserDAOImpl.class);
	// property constants
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String EMAIL = "email";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.ljp.daoimpl.UserDAO#save(com.ljp.entity.User)
	 */
	@Override
	public void save(User transientInstance) {
		log.debug("saving User instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ljp.daoimpl.UserDAO#delete(com.ljp.entity.User)
	 */
	@Override
	public void delete(User persistentInstance) {
		log.debug("deleting User instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ljp.daoimpl.UserDAO#findById(java.lang.Integer)
	 */
	@Override
	public User findById(java.lang.Integer id) {
		log.debug("getting User instance with id: " + id);
		try {
			User instance = (User) getHibernateTemplate().get(
					"com.ljp.daoimpl.User", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ljp.daoimpl.UserDAO#findByExample(com.ljp.entity.User)
	 */
	@Override
	public List findByExample(User instance) {
		log.debug("finding User instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ljp.daoimpl.UserDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding User instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from User as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ljp.daoimpl.UserDAO#findByUsername(java.lang.Object)
	 */
	@Override
	public List findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	/* (non-Javadoc)
	 * @see com.ljp.daoimpl.UserDAO#findByPassword(java.lang.Object)
	 */
	@Override
	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	/* (non-Javadoc)
	 * @see com.ljp.daoimpl.UserDAO#findByEmail(java.lang.Object)
	 */
	@Override
	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	/* (non-Javadoc)
	 * @see com.ljp.daoimpl.UserDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all User instances");
		try {
			String queryString = "from User";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ljp.daoimpl.UserDAO#merge(com.ljp.entity.User)
	 */
	@Override
	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			User result = (User) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ljp.daoimpl.UserDAO#attachDirty(com.ljp.entity.User)
	 */
	@Override
	public void attachDirty(User instance) {
		log.debug("attaching dirty User instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ljp.daoimpl.UserDAO#attachClean(com.ljp.entity.User)
	 */
	@Override
	public void attachClean(User instance) {
		log.debug("attaching clean User instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UserDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UserDAO) ctx.getBean("UserDAO");
	}
}