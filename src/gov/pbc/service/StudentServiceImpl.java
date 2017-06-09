package gov.pbc.service;

import java.util.List;

import gov.pbc.dao.StudentDAO;
import gov.pbc.dao.UserDAO;
import gov.pbc.model.Student;
import gov.pbc.model.User;

public class StudentServiceImpl implements StudentService{
	private StudentDAO studentDAO;
	private UserDAO userDAO;
	
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}



	public Student findById(int id){
		return studentDAO.findById(id);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDAO.findAll();
	}

}
