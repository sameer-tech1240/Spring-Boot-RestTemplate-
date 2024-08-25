package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.app.entity.Student;
import com.app.response.Collage;
import com.app.response.ResponseData;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private WebClient.Builder webClient;

	@SuppressWarnings("deprecation")
	@GetMapping("/{studentId}")
	public ResponseEntity<ResponseData> getStudentData(@PathVariable Integer studentId) {

		ResponseData response = new ResponseData();

		Student student = new Student();
		student.setStudentId(1);
		student.setStudentName("Sameer");
		student.setAddress("Mumbai");
		student.setCollageId(12);
		/*
		 * student.setCollageId(); hear i call rest template or WebClient to communicate
		 * both api's
		 */

		response.setStudent(student);

		Integer collageId = student.getCollageId();

		RestTemplate restTemplate = new RestTemplate();
		String endPoint = "http://localhost:8989/collage/{collageId}";
		ResponseEntity<Collage> data = restTemplate.getForEntity(endPoint, Collage.class, collageId);
		if (data.getStatusCodeValue() == 200) {
			Collage collage = data.getBody();
			response.setCollage(collage);
		}

		/* Communicate both api's using webclient */

		/*
		 * Collage collageApiData =
		 * webClient.build().get().uri("http://localhost:8989/collage/" +
		 * collageId).retrieve() .bodyToMono(Collage.class).block();
		 * response.setCollage(collageApiData);
		 */
		return new ResponseEntity<ResponseData>(response, HttpStatus.OK);

	}

}
