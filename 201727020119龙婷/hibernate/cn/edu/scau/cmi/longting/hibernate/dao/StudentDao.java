package cn.edu.scau.cmi.longting.hibernate.dao;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.scau.cmi.longting.hibernate.domain.Student;
import cn.edu.scau.cmi.longting.hibernate.util.ScauCmiHibernateSessionFactoryUtil;

public class StudentDao {
	private static final Logger log = LoggerFactory.getLogger(StudentDao.class);
	private static final String NAME = "name";
	private Session session;
	
	public void save(Student student) {
		try {
			this.getSession();
			Transaction transaction = session.beginTransaction();
			session.save(student);
			transaction.commit();
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public void delete(Student student) {
		log.debug("deleting Student instance");
		try {
			this.getSession();
			Transaction transaction = session.beginTransaction();
			session.delete(student);
			transaction.commit();
			log.debug("delete successful");
			
		} catch (Exception e) {
			log.error("delete faild", e);
			throw e;
		}
	}
	
	public Student findById(Long id) {
		log.debug("getting Student instance with id: " + id);
		try {
			Student instance = (Student) session.get("cn.edu.scau.cmi.longting.hibernate.domain.Student", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public List findByExample(Student student) {
		log.debug("finding Student instance by example");
		try {
			List results = getSession().createCriteria("cn.edu.scau.cmi.longting.hibernate.domain.Student")
					.add(Example.create(student)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Student instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Student as model where model."+propertyName+"= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}		
	}
	
	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}
	
	public List findAll() {
		log.debug("finding all Student instances");
		try {
			String queryString = "from Student";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
		
	}
	
	public Student merge(Student student) {
		log.debug("merging Student instance");
		try {
			this.getSession();
			Transaction transaction = session.beginTransaction();			
			Student result = (Student) session.merge(student);
			transaction.commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	
	public void attachDirty(Student student) {
		log.debug("attaching dirty Student instance");
		try {
			this.getSession();
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(student);
			transaction.commit();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public void attachClean(Student student) {
		log.debug("attaching clean Student instance");
		try {
			this.getSession();
			Transaction transaction = session.beginTransaction();
			session.buildLockRequest(LockOptions.NONE).lock(student);
			transaction.commit();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public Session getSession() {
		session = ScauCmiHibernateSessionFactoryUtil.getSession();
		return session;
	}

}
