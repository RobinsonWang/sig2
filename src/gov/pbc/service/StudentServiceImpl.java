package gov.pbc.service;

import javax.annotation.Resource;

import gov.pbc.dao.StudentDAO;
import gov.pbc.model.Student;

public class StudentServiceImpl implements StudentService{
	@Resource
	private StudentDAO studentDAO;
	
	public void addStudent(Student stu){
		studentDAO.save(stu);
	}

}
