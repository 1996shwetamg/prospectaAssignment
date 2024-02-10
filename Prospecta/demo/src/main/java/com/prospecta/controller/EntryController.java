package com.prospecta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prospecta.dto.APIresponse;
import com.prospecta.model.Entry;
import com.prospecta.service.EntryService;

@RestController
public class EntryController {
private final EntryService entryservice;

@Autowired
public EntryController(EntryService entryService) {
	this.entryservice = entryService;
}



@GetMapping("/entities")
public ResponseEntity<?> fetchAllProducts(@RequestParam String category) {
	APIresponse fetchEntriesFromApI = entryservice.fetchEntriesFromApI(category);
	return new ResponseEntity<>(fetchEntriesFromApI, HttpStatus.OK);
}


@PostMapping("/entities")
public ResponseEntity<?> createEntry(@RequestBody Entry entry) {
	entryservice.saveEntry(entry);
	return new ResponseEntity<>("Product created Successfully.", HttpStatus.CREATED);
}
}