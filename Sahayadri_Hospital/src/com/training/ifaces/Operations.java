package com.training.ifaces;

import java.util.List;

public interface Operations<S,T> {

	public void add(S s,T t);               // add entity to that list
	public List<T> get(S s);                // retrieve the list of patients
}
