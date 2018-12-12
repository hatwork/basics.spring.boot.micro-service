package com.hatim.spring.microservice.registration;

import java.util.Map;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="student-micro-service")
@RibbonClient(name="student-micro-service")
public interface StudentServiceProxy {

	@GetMapping(value="/student/exist/{id}")
	public Map<String, Object> studentIdExist(@PathVariable("id") String id);
	
}
