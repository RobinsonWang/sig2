package gov.pbc.dao;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public abstract class BasicDAOImpl<T> implements BasicDAO<T> {
	private SessionFactory sessionFactory;
	
	private HibernateTemplate hibernateTemplate;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	protected HibernateTemplate getHibernateTemplate(){
		if(hibernateTemplate==null)
			hibernateTemplate = new HibernateTemplate(sessionFactory);
		return hibernateTemplate;
	}
	
	public void save(T t){
		getHibernateTemplate().save(t);
	}
	
	public void update(T t){
		getHibernateTemplate().update(t);
	}
	
	public void delete(T t){
		getHibernateTemplate().update(t);
	}

}
