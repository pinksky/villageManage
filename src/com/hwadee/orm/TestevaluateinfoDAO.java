package com.hwadee.orm;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Testevaluateinfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.hwadee.orm.Testevaluateinfo
 * @author MyEclipse Persistence Tools
 */

public class TestevaluateinfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TestevaluateinfoDAO.class);
	// property constants
	public static final String TERESULT = "teresult";
	public static final String WARRANTY_PERIOD = "warrantyPeriod";
	public static final String TEACCEPT_NAME = "teacceptName";
	public static final String TEACCEPT_OPINION = "teacceptOpinion";
	public static final String GUARANTEE_MONEY = "guaranteeMoney";
	public static final String TEMASSES_EVALUATE_RESULT = "temassesEvaluateResult";
	public static final String WRITE_TABLE_NAME = "writeTableName";
	public static final String UNIT_NAME = "unitName";
	public static final String TABLE_COMMENT = "tableComment";

	public void save(Testevaluateinfo transientInstance) {
		log.debug("saving Testevaluateinfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Testevaluateinfo persistentInstance) {
		log.debug("deleting Testevaluateinfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Testevaluateinfo findById(java.lang.Integer id) {
		log.debug("getting Testevaluateinfo instance with id: " + id);
		try {
			Testevaluateinfo instance = (Testevaluateinfo) getSession().get(
					"com.hwadee.orm.Testevaluateinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Testevaluateinfo instance) {
		log.debug("finding Testevaluateinfo instance by example");
		try {
			List results = getSession()
					.createCriteria("com.hwadee.orm.Testevaluateinfo")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Testevaluateinfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Testevaluateinfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTeresult(Object teresult) {
		return findByProperty(TERESULT, teresult);
	}

	public List findByWarrantyPeriod(Object warrantyPeriod) {
		return findByProperty(WARRANTY_PERIOD, warrantyPeriod);
	}

	public List findByTeacceptName(Object teacceptName) {
		return findByProperty(TEACCEPT_NAME, teacceptName);
	}

	public List findByTeacceptOpinion(Object teacceptOpinion) {
		return findByProperty(TEACCEPT_OPINION, teacceptOpinion);
	}

	public List findByGuaranteeMoney(Object guaranteeMoney) {
		return findByProperty(GUARANTEE_MONEY, guaranteeMoney);
	}

	public List findByTemassesEvaluateResult(Object temassesEvaluateResult) {
		return findByProperty(TEMASSES_EVALUATE_RESULT, temassesEvaluateResult);
	}

	public List findByWriteTableName(Object writeTableName) {
		return findByProperty(WRITE_TABLE_NAME, writeTableName);
	}

	public List findByUnitName(Object unitName) {
		return findByProperty(UNIT_NAME, unitName);
	}

	public List findByTableComment(Object tableComment) {
		return findByProperty(TABLE_COMMENT, tableComment);
	}

	public List findAll() {
		log.debug("finding all Testevaluateinfo instances");
		try {
			String queryString = "from Testevaluateinfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Testevaluateinfo merge(Testevaluateinfo detachedInstance) {
		log.debug("merging Testevaluateinfo instance");
		try {
			Testevaluateinfo result = (Testevaluateinfo) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Testevaluateinfo instance) {
		log.debug("attaching dirty Testevaluateinfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Testevaluateinfo instance) {
		log.debug("attaching clean Testevaluateinfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/**
	 * @param proId
	 * @return
	 * @author ղ����
	 * @date:2014-7-24����9:20:26
	 */
	public Testevaluateinfo getTestEvaByProject(String proId) {
		String hql = "SELECT p.testevaluateinfos FROM Project p WHERE p.proId=:proId";
		Query query = getSession().createQuery(hql);
		query.setParameter("proId", proId);
		return (Testevaluateinfo) query.uniqueResult();
	}
}