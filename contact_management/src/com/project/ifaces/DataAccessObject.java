package com.project.ifaces;

import java.util.List;

public interface DataAccessObject<T> {

	public int add(T t);
	public int update(T t);
	public List<T> findAll();
	public int remove(int mobileNumber);
}
