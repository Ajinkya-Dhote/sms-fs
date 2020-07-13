package in.ajinkyadhote.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ajinkyadhote.model.SmsData;
import in.ajinkyadhote.service.SmsService;

@RestController
@RequestMapping("/api")
public class SmsController {
	private static final Logger LOGGER = LoggerFactory.getLogger(SmsController.class);
	
	@Autowired
	private SmsService service;

	@GetMapping("/")
	public ResponseEntity<List<SmsData>> getAllData() {
		LOGGER.debug("Getting all data");
		
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SmsData> getAllData(@PathVariable("id") Integer id) {
		LOGGER.debug("Get data for entity with id - {}", id);
		
		if (service.find(id).isPresent()) {
			return new ResponseEntity<>(service.find(id).get(), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/")
	public ResponseEntity<SmsData> addData(@RequestBody SmsData data) {
		LOGGER.debug("adding new entry to database, data: {}", data);
		
		return new ResponseEntity<>(service.add(data), HttpStatus.OK);
	}
	
	@PostMapping("/bulk")
	public ResponseEntity<String> addData(@RequestBody List<SmsData> data) {
		LOGGER.debug("adding new entry to database, data: {}", data);
		
		service.add(data);
		return new ResponseEntity<>("Data added", HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<SmsData> updateData(@RequestBody SmsData data) {
		LOGGER.debug("updating entry in database, data: {}", data);
		
		return new ResponseEntity<>(service.update(data), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteData(@PathVariable("id") Integer id) {
		LOGGER.debug("deleting entry in database, id: {}", id);
		
		service.delete(id);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}
	
}
