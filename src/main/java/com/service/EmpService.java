package com.service;

import java.util.List;

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
	
	public void updateEmp(Employee e) {
		
	}
	
	public void deleteEmp(Employee e) {
		empRepo.delete(e);
	}
	
    public List<Employee> listEmp() {
		return empRepo.findAll();
	}
}
