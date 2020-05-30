package com.gulcu.murat.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gulcu.murat.entities.Person;
import com.gulcu.murat.service.RestTepmlateService;

@Service
public class RestTemplateServiceImpl implements RestTepmlateService{
	
	private static final String webUrl = "http://localhost:8080/api";
	
	private final RestTemplate restTemplate;

	public RestTemplateServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public Iterable<Person> findAll() {
		ResponseEntity<Iterable> result = restTemplate.getForEntity(webUrl+"/person/all", Iterable.class);
		Iterable<Person> persons = result.getBody();
		return persons;
	}

	@Override
	public Person save(Person p) {
		ResponseEntity<Person> person = restTemplate.postForEntity(webUrl+"/person/save", p, Person.class);
		Person resultPerson = person.getBody();
		return resultPerson;
	}

	
}
