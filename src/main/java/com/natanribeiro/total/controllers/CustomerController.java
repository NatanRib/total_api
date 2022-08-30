package com.natanribeiro.total.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natanribeiro.total.models.Customer;
import com.natanribeiro.total.repositories.CustomerRespository;

@RestController
@RequestMapping("/customers")
public class CustomerController {
		
	@Autowired
	private CustomerRespository repository;
	
	@GetMapping
	public List<Customer> find() {
		return repository.findAll();
	}
	
	@PostMapping
	public Customer save(@RequestBody Customer customer) {
		return repository.save(customer);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> findById(@PathVariable Long id) {
		var body = repository.findById(id);
		return ResponseEntity.of(body);
	}
	
	@PutMapping("/{id}")
	public Customer updateById(@PathVariable Long id, @RequestBody Customer customer){
		var customerFinded = repository.findById(id);
		
		Customer c = customerFinded.get();
		c.setDocument(customer.getDocument());
		c.setName(customer.getName());
		c.setPhone(customer.getPhone());
		
		return repository.save(c);
	}
}
