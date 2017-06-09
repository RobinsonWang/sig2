package gov.pbc.dao;

public interface BasicDAO<T> {
	public void save(T t);
	public void update(T t);
	public void delete(T t);

}
