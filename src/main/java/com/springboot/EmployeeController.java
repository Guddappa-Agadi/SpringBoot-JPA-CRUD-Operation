package com.springboot;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository er;

	@PostMapping("/add")
	public <S extends Employee> S save(@RequestBody S entity) {
		return er.save(entity);
	}

	@GetMapping("/get/page")
	public List<Employee> findAll(Pageable pageable) {
		Page<Employee> p = er.findAll(pageable);
		return p.getContent();
	}

	@GetMapping("/get")
	public List<Employee> findAll() {
		return er.findAll();
	}

	@GetMapping("/get/{id}")
	public Optional<Employee> findById(@PathVariable Integer employee_id) {
		return er.findById(employee_id);
	}

	@PutMapping("/get/{id}")
	public Employee findById(@PathVariable Integer employee_id, @RequestBody Employee e) {
		return er.save(e);
	}

	@DeleteMapping("/get/{id}")
	public void deleteById(@PathVariable Integer employee_id) {
		er.deleteById(employee_id);
	}

}
