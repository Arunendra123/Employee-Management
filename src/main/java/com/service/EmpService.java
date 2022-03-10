package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Employee;
import com.repository.EmpRepo;

@Service
public class EmpService {

	@Autowired
	private EmpRepo empRepo;
	
	public void addEmp(Employee e) {
		empRepo.save(e);
	}
	
	public Employee getEmpById(Integer id) {
		Optional<Employee> e=empRepo.findById(id);
		if (!e.isEmpty()) {
			return e.get();
		} else {
			return null;
		}
	}
	
	public void deleteEmp(Integer id) {
		empRepo.deleteById(id);;
	}
	
    public List<Employee> listEmp() {
		return empRepo.findAll();
	}
}
