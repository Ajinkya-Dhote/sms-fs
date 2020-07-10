package in.ajinkyadhote.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@PutMapping("/")
	public ResponseEntity<String> addData(@RequestBody SmsData data) {
		LOGGER.info("adding new entry to database, data: {}", data);
		
		service.add(data);
		return new ResponseEntity<>("Data added", HttpStatus.OK);
	}
	
	@PutMapping("/bulk")
	public ResponseEntity<String> addData(@RequestBody List<SmsData> data) {
		LOGGER.debug("adding new entry to database, data: {}", data);
		
		service.add(data);
		return new ResponseEntity<>("Data added", HttpStatus.OK);
	}
	
}
