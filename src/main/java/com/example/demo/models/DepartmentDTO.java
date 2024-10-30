package com.example.demo.models;

public class DepartmentDTO {
	
private Integer dept_id;
	
	private String dept_name;
	
	private Integer comp_id;
	
	private String comp_name;

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

	public String getComp_name() {
		return comp_name;
	}

	public void setComp_name(String comp_name) {
		this.comp_name = comp_name;
	}

//	@Override
//	public String toString() {
//		return "DepartmentDTO [dept_id=" + dept_id + ", dept_name=" + dept_name + ", comp_id=" + comp_id
//				+ ", comp_name=" + comp_name + "]";
//	}

	/**
	 * @param dept_id
	 * @param dept_name
	 * @param comp_id
	 * @param comp_name
	 */
	public DepartmentDTO(Integer dept_id, String dept_name, Integer comp_id, String comp_name) {
		super();
		this.dept_id = dept_id;
		this.dept_name = dept_name;
		this.comp_id = comp_id;
		this.comp_name = comp_name;
	}

	/**
	 * 
	 */
	public DepartmentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
