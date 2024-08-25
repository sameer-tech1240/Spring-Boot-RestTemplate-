package com.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Collage;

@RestController
@RequestMapping("/collage")
public class CollageController {

	@GetMapping("/{collageId}")
	public ResponseEntity<Collage> getCollageDetails(@PathVariable Long collageId) {

		Collage collage = new Collage();

		collage.setCollageId(1);
		collage.setCollageName("Corporate Collage");
		collage.setAddress("Mumbai");

		return new ResponseEntity<Collage>(collage, HttpStatus.OK);
	}

}
