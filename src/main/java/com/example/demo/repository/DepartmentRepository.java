package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Department;

@Repository("deptrepo")
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
