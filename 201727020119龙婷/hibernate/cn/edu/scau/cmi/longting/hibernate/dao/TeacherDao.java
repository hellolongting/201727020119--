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
import cn.edu.scau.cmi.longting.hibernate.domain.Teacher;
import cn.edu.scau.cmi.longting.hibernate.util.ScauCmiHibernateSessionFactoryUtil;

public class TeacherDao {
	private static final Logger log = LoggerFactory.getLogger(TeacherDao.class);
	private static final String NAME = "name";
	private Session session;
	
	public void save(Teacher teacher) {
		this.getSession();
		Transaction Transaction = session.beginTransaction();
		session.save(teacher);
		Transaction.commit();
	}
	
	public void delete(Teacher teacher) {
		log.debug("deleting Student instance");
		try {
			this.getSession();
			Transaction transaction = session.beginTransaction();
			session.delete(teacher);
			transaction.commit();
			log.debug("delete successful");
		} catch (Exception e) {
			log.error("delete faild", e);
			throw e;
		}
		
	}
	
	public Teacher findById(Long id) {
		log.debug("getting Teacher instance with id: " + id);
		try {
			Teacher instance = (Teacher) getSession().get("cn.edu.scau.cmi.longting.hibernate.domain.Teacher", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public List findByExample(Teacher teacher) {
		log.debug("finding Teacher instance by example");
		try {
			List results = getSession().createCriteria("cn.edu.scau.cmi.longting.hibernate.domain.Teacher")
					.add(Example.create(teacher)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Teacher instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Teacher as model where model."+propertyName+"= ?";
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
		log.debug("finding all Teacher instances");
		try {
			String queryString = "from Teacher";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
		
	}
	
	public Teacher merge(Teacher teacher) {
		log.debug("merging Teacher instance");
		try {
			this.getSession();
			Transaction transaction = session.beginTransaction();			
			Teacher result = (Teacher) session.merge(teacher);
			transaction.commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	
	public void attachDirty(Teacher teacher) {
		log.debug("attaching dirty Student instance");
		try {
			this.getSession();
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(teacher);
			transaction.commit();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public void attachClean(Teacher teacher) {
		log.debug("attaching clean Student instance");
		try {
			this.getSession();
			Transaction transaction = session.beginTransaction();
			session.buildLockRequest(LockOptions.NONE).lock(teacher);
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