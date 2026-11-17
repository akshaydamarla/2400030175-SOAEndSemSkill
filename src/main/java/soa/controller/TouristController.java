package soa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import soa.model.Tourist;
import soa.repository.TouristRepository;

@RestController
@RequestMapping("/api")
public class TouristController {
	
	TouristRepository repository;

	public TouristController(TouristRepository repository) {
		this.repository = repository;
	}
	
	final String valid_token = "1234567890";
	@GetMapping("/tourists")
	public ResponseEntity<?> getAllTourists(@RequestHeader(value = "Token", required = false) String token){
		if(token == null||!token.equals(valid_token)) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unauthorized: Invalid Token Provided");
		}
		List<Tourist> tourists = repository.findAll();
		
		return ResponseEntity.ok(tourists);
		
		
	}
	
	

}
