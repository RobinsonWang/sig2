package gov.pbc.service;

import java.util.List;

import javax.annotation.Resource;

import gov.pbc.dao.StudentDAO;
import gov.pbc.dao.UserDAO;
import gov.pbc.model.Student;
import gov.pbc.model.User;

public class StudentServiceImpl implements StudentService{
	@Resource
	private StudentDAO studentDAO;
	@Resource
	private UserDAO userDAO;
	

	public Student findById(int id){
		return studentDAO.findById(id);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDAO.findAll();
	}

}
