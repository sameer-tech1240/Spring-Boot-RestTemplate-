package com.boot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.JournalEntity;

@RestController
@RequestMapping("/journal")
public class JournalController {
	Map<Long, JournalEntity> journal = new HashMap<>();

	@GetMapping("/getAll")
	public List<JournalEntity> getAll() {
		return new ArrayList<>(journal.values());
	}

	@PostMapping("/save")
	public boolean createEntry(@RequestBody JournalEntity entity) {
		journal.put(entity.getId(), entity);
		return true;

	}

	@GetMapping("/getById/{id}")
	public JournalEntity getJournalEntryById(@PathVariable Long id) {

		return journal.get(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public JournalEntity deleteEntryById(@PathVariable Long id) {
		return journal.remove(id);
		
	}
	
	@PutMapping("/update/{id}")
	public JournalEntity updateJournalById(@PathVariable Long id , @RequestBody JournalEntity entity) {
		return journal.put(id, entity);
		
	}

}
