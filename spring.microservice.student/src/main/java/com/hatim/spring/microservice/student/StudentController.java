package com.hatim.spring.microservice.student;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private Environment environment;

	@GetMapping(value = "/exist/{id}")
	public Map<String, Object> studentIdExist(@PathVariable String id) {

		Map<String, Object> response = new HashMap<>();
		response.put("id", id);

		if ("hatim".equals(id) || "kamaal".equals(id)) {
			response.put("exist", true);
		} else {
			response.put("exist", false);
		}
		
		
		response.put("port", environment.getProperty("local.server.port"));

		return response;
	}

}
