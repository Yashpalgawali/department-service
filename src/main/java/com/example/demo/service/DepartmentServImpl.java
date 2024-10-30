package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Department;
import com.example.demo.repository.DepartmentRepository;

@Service("deptserv")
public class DepartmentServImpl implements DepartmentService {

	private DepartmentRepository deptrepo;
	
	/**
	 * @param deptrepo
	 */
	public DepartmentServImpl(DepartmentRepository deptrepo) {
		super();
		this.deptrepo = deptrepo;
	}

	@Override
	public Department saveDepartment(Department dept) {
		// TODO Auto-generated method stub
		return deptrepo.save(dept);
	}

	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return deptrepo.findAll();
	}

	@Override
	public Department getDepartmentById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Department> deptobj = deptrepo.findById(id);
		if(!deptobj.isEmpty()) {
			return deptobj.get();
		}
		else {
			return null;
		}
		
	}

}
