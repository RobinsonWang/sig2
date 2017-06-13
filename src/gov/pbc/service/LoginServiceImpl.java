package gov.pbc.service;

import java.util.List;

import javax.annotation.Resource;

import gov.pbc.dao.UserDAO;
import gov.pbc.model.User;

public class LoginServiceImpl implements LoginService{
	@Resource
	private UserDAO userDAO;
	

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDAO.findAll();
	}
	
	public List<User> getUserByUsername(String username){
		return userDAO.findByProperty("username", username);
	}

}
