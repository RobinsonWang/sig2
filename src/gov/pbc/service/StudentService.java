package gov.pbc.service;

import java.util.List;
import gov.pbc.model.Student;
import gov.pbc.model.User;

public interface StudentService {
	public Student findById(int id);
	public List<User> findAll();

}
