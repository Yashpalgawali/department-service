package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Company;
import com.example.demo.models.Department;
import com.example.demo.models.DepartmentDTO;
import com.example.demo.proxy.CompanyProxyClient;
import com.example.demo.service.DepartmentService;

@RestController
@RequestMapping("department")
public class DepartmentController {

	private Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	private DepartmentService deptserv;
	
	private CompanyProxyClient companyproxy;

	/**
	 * @param deptserv
	 */
	
	public DepartmentController(DepartmentService deptserv,CompanyProxyClient companyproxy) {
		super();
		this.deptserv = deptserv;
		this.companyproxy = companyproxy;
	}
	
	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department) {
		
		Department dept = deptserv.saveDepartment(department);
		if(dept!=null) {
			return dept;
		}
		else {
			return null;
		}
	}
	
//	@GetMapping("/")
//	public List<Department> getAllDepartments() {
//		List<Department> deptlist = deptserv.getAllDepartments();
//		
//		return deptlist;
//	}
	
	
	@GetMapping("/")
	public List<DepartmentDTO> getAllDepartments() {
		List<Department> deptlist = deptserv.getAllDepartments();
		
		List<DepartmentDTO> dplist = deptlist.stream().map(d -> { 
			// Fetch company details based on comp_id
			ResponseEntity<Company> company = companyproxy.getCompanyById(d.getComp_id());
			Company comp = company.getBody();
			// Create and populate DepartmentDTO
	        DepartmentDTO dto = new DepartmentDTO();
			if(comp==null) {
				dto.setDept_id(d.getDept_id());
				dto.setDept_name(d.getDept_name());
				return null;
			}
			
	        dto.setDept_id(d.getDept_id());
	        dto.setDept_name(d.getDept_name());
	        dto.setComp_id(comp.getCompany_id());
	        dto.setComp_name(comp.getComp_name());

	        return dto; // Return the created DepartmentDTO
			
		}).collect(Collectors.toList());
 
		return dplist;
	} 


	@GetMapping("/{id}")
	public  DepartmentDTO getDepartmentById(@PathVariable Integer id) {
		Department dept= deptserv.getDepartmentById(id);
		
		logger.info("Department Object is {}",dept);
		
		DepartmentDTO deptdto = new DepartmentDTO();
		
		ResponseEntity<Company> comp = companyproxy.getCompanyById(dept.getComp_id());
		Company company = comp.getBody();
		if(company!=null) {
			deptdto.setDept_id(id);
			deptdto.setDept_name(dept.getDept_name());
			deptdto.setComp_id(company.getCompany_id());
			deptdto.setComp_name(company.getComp_name());
		}
		else {
			deptdto.setDept_id(id);
			deptdto.setDept_name(dept.getDept_name());
		}
		 
		if(dept!=null) {
			return deptdto;
		}
		else {
			return null;
		}
	}
}
