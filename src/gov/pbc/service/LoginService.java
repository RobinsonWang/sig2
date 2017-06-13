package gov.pbc.service;

import java.util.List;
import gov.pbc.model.User;

public interface LoginService {
	public List<User> findAll();
	public List<User> getUserByUsername(String username);
}
