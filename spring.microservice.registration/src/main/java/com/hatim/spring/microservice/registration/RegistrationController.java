package com.hatim.spring.microservice.registration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class RegistrationController {

	@Autowired
	private StudentServiceProxy proxy;
	
	@PostMapping(value="/register")
	public Map<String, Object> register(RegistrationBean bean) {
		
		Map<String, Object> response = new HashMap<>();
		response.put("details", bean);
		
		
//		HttpHeaders headers = new HttpHeaders();
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//		
//		HttpEntity<String> request = new HttpEntity<String>(headers);
//		
//		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<Object> resp = restTemplate.exchange("http://localhost:8001/student/exist/"+bean.getId(), HttpMethod.GET, request, Object.class);
//		LinkedHashMap<String, Object> usersMap = (LinkedHashMap<String, Object>) resp.getBody();
//		
//		Object a = usersMap.get("exist");
		
		
		Map<String, Object> resp = proxy.studentIdExist(bean.getId());
		
		response.put("registered", !(boolean)resp.get("exist"));
		response.put("port", resp.get("port"));
		
		return response;
	}
	
	
}
