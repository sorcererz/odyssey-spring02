package com.wildcodeschool.DoctorWho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
@SpringBootApplication
public class DoctorWhoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorWhoApplication.class, args);
	}
	
	@RequestMapping("/doctor/{id}")
	@ResponseBody
	public String getDoctor(@PathVariable String id) {
		String result = "";
		if (Integer.parseInt(id) < 9) {
			throw new ResponseStatusException(HttpStatus.SEE_OTHER); 
		} else if (Integer.parseInt(id) > 13 || Integer.parseInt(id) == 0){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de récupérer l'incarnation " + id);
		} else {
			switch(Integer.parseInt(id)) {
			case 9:
				result = " {\"number\": 9, \"name\": \"Christopher Eccleston\"}";
				break;
			case 10:
				result = " {\"number\": 10, \"name\": \"David Tennant\"}";
				break;
			case 11:
				result = " {\"number\": 11, \"name\": \"Matt Smith\"}";
				break;
			case 12:
				result = " {\"number\": 12, \"name\": \"Peter Capaldi\"}";
				break;
			case 13:
				result = " {\"number\": 13, \"name\": \"Jodie Whittaker\"}";
				break;
			}
		}  
		return result;
	}
}
