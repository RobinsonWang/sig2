package gov.pbc.dao;

import java.util.List;

import gov.pbc.model.User;

public class UserDAOImpl extends BasicDAOImpl<User> implements UserDAO{

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		String queryStr = "from User";
		List<User> userList = this.getHibernateTemplate().find(queryStr);
		return userList;
	}
	
}
