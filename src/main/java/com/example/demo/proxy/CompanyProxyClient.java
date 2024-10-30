package com.example.demo.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.models.Company;

@Configuration
@FeignClient(name = "company-service" )
public interface CompanyProxyClient {
	
	@GetMapping("/company/{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable Integer id);
}
