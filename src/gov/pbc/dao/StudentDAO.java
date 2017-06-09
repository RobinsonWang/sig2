package gov.pbc.dao;

import gov.pbc.model.Student;

public interface StudentDAO extends BasicDAO<Student>{
	public Student findById(int id);
}
