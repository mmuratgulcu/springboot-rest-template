package com.gulcu.murat.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gulcu.murat.entities.Person;
import com.gulcu.murat.service.impl.RestTemplateServiceImpl;

@RestController
@RequestMapping("/client")
public class RestClientController {

	
	private final RestTemplateServiceImpl restTemplateService;

	public RestClientController(RestTemplateServiceImpl restTemplateService) {
		this.restTemplateService = restTemplateService;
	}
	
	
	
	@GetMapping("/person/all")
	public ResponseEntity<Iterable<Person>> findAll(){		
		return ResponseEntity.ok(restTemplateService.findAll());
	}
	
	@PostMapping("/person/save")
	public ResponseEntity<Person> save(@RequestBody Person person){		
		return ResponseEntity.ok(restTemplateService.save(person));
	}
	
}
