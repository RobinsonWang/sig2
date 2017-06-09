package gov.pbc.dao;

import gov.pbc.model.Student;

public class StudentDAOImpl extends BasicDAOImpl<Student> implements StudentDAO{
	
	
	public Student findById(int id){
		return getHibernateTemplate().get(Student.class, id);
	}
	
	

}
