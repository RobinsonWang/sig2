package gov.pbc.dao;

import java.util.List;

import gov.pbc.model.User;

public interface UserDAO extends BasicDAO<User>{
	public List<User> findAll();
}
