package gov.pbc.dao;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import gov.pbc.model.Student;

public class StudentDAOImpl implements StudentDAO{
	private SessionFactory sessionFactory;
	
	HibernateTemplate hibernateTemplate;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	private HibernateTemplate getHibernateTemplate(){
		if(hibernateTemplate==null)
			hibernateTemplate = new HibernateTemplate(sessionFactory);
		return hibernateTemplate;
	}
	
	public Student findById(int id){
		return (Student)getHibernateTemplate().get(Student.class, new Integer(id));
	}

}
