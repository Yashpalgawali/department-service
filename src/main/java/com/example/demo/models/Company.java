package com.example.demo.models;

public class Company {

private Integer company_id;
	
	private String comp_name;

	public Integer getCompany_id() {
		return company_id;
	}

	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}

	public String getComp_name() {
		return comp_name;
	}

	public void setComp_name(String comp_name) {
		this.comp_name = comp_name;
	}

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Company(Integer company_id, String comp_name) {
		super();
		this.company_id = company_id;
		this.comp_name = comp_name;
	}
}
