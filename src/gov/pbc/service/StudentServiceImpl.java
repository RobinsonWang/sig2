package gov.pbc.service;

import gov.pbc.dao.StudentDAO;
import gov.pbc.model.Student;

public class StudentServiceImpl implements StudentService{
	private StudentDAO studentDAO;
	public void setStudentDAO(StudentDAO studentDAO){
		this.studentDAO = studentDAO;
	}
	
	public Student findById(int id){
		return studentDAO.findById(id);
	}

}
