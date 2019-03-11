package com.tasif.service;

import java.util.List;

import com.tasif.model.Person;

public interface AddressBook {
	public List<Person> add();
	public void edit();
	public void remove() throws Exception;
	public void sortByName();
	public void sortByZip();
	public void printAll();
}
