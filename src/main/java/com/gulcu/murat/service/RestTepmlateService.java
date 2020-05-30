package com.gulcu.murat.service;

import com.gulcu.murat.entities.Person;

public interface RestTepmlateService {

	Iterable<Person> findAll();
	Person save(Person person);
}
