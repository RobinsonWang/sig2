package gov.pbc.dao;

import java.util.List;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class BasicDAOImpl<T> implements BasicDAO<T> {
	private static final Logger log = LoggerFactory.getLogger(BasicDAOImpl.class);
	
	@Resource
	HibernateTemplate hibernateTemplate;
	
	private Class<T> entityClass;
	String orderPropertyName = "";
	boolean DESC = false;
	
	public BasicDAOImpl() {
		this.entityClass = null;
		Class c = getClass();
		Type t = c.getGenericSuperclass();
		if (t instanceof ParameterizedType) {
			Type[] p = ((ParameterizedType) t).getActualTypeArguments();
			this.entityClass = (Class<T>) p[0];
			
		}
	}
	
	
	@Transactional(rollbackFor = RuntimeException.class)
	public void save(T instance){
		log.debug("saving instance");
		try {
			hibernateTemplate.save(instance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
		}
	}
	
	@Transactional(rollbackFor = RuntimeException.class)
	public void update(T instance){
		log.debug("update instance info");
		try {
			hibernateTemplate.update(instance);
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
	}
	
	@Transactional(rollbackFor = RuntimeException.class)
	public void delete(T instance){
		log.debug("deleting instance");
		try {
			hibernateTemplate.delete(instance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public T findById(int id) {
		log.debug("getting instance with id: " + id);
		try {
			return (T) hibernateTemplate.get(entityClass, id);
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		log.debug("finding all instances");
		try {
			String queryString = "from " + getTableName();
			queryString = addOrderBy(queryString);
			return hibernateTemplate.find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}

	}
	
	
	private String getTableName() {
		return entityClass.getSimpleName();
	}
	
	private String addOrderBy(String queryString) {
		if (!orderPropertyName.equals("")) {
			queryString += " order by " + orderPropertyName;
			if (isDESC()) {
				queryString += " DESC";
			}
		}
		return queryString;
	}
	
	public boolean isDESC() {
		return DESC;
	}

	public void setDESC(boolean DESC) {
		this.DESC = DESC;
	}

}
