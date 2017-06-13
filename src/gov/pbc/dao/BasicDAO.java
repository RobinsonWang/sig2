package gov.pbc.dao;

import java.util.List;

public interface BasicDAO<T> {
	
	public void save(T instance);
	
	public void update(T instance);
	
	public void delete(T instance);
	
	public T findById(int id);
	
	public List<T> findAll();
	
	public List<T> findByProperty(String propertyName, Object value);
	
	public boolean isDESC();

	public void setDESC(boolean DESC);

}
