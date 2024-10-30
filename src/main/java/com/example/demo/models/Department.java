package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_department")
@SequenceGenerator(name="dept_seq",allocationSize = 1 ,initialValue = 1)
public class Department {
	
	@Id @GeneratedValue(generator = "dept_seq",strategy = GenerationType.AUTO)
	private Integer dept_id;
	
	private String dept_name;
	
	private Integer comp_id;

	public Integer getDept_id() {
		return dept_id;
	}

	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public Integer getComp_id() {
		return comp_id;
	}

	public void setComp_id(Integer comp_id) {
		this.comp_id = comp_id;
	}

	public Department(Integer dept_id, String dept_name, Integer comp_id) {
		super();
		this.dept_id = dept_id;
		this.dept_name = dept_name;
		this.comp_id = comp_id;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

//	@Override
//	public String toString() {
//		return "Department [dept_id=" + dept_id + ", dept_name=" + dept_name + ", comp_id=" + comp_id + "]";
//	}

	
	
}
