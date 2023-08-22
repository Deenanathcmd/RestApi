package com.example.day5.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day5.model.HotelModel;
import com.example.day5.service.HotelService;

@RestController
public class HotelController {
	@Autowired
	HotelService hser;
	@PostMapping("/savehotel")
	public HotelModel saveHotelDe(@RequestBody HotelModel hm)
	{
		return hser.saveDetails(hm);
	}
	@PutMapping("/updatehotel/HotelId")
	public HotelModel updateHotelDe(@RequestBody HotelModel hm) {
		return hser.updateDetails(hm);
	}
	@DeleteMapping("/delete/{HotelId}")
	public String deleteds(@PathVariable("HotelId")int HotelId) {
		hser.delete(HotelId);
		return "name with Id "+HotelId+" is deleted";
	}
	@DeleteMapping("/deleteHotel/{HotelId}")
	public ResponseEntity<String> deleteHotelInfo(@PathVariable int HotelId){
		boolean deleted = hser.deleteHotel(HotelId);
		
		if (deleted) {
			return ResponseEntity.ok("Hotel with ID " + HotelId+ " deleted successfully");
		}
		
		else{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel with ID" + HotelId+ " not found");
		}
		
	}
	@GetMapping("/users/{userId}")
	public ResponseEntity<?>getUserId(@PathVariable int userId)
	{
	Optional<HotelModel>hotel=hser.getUserId(userId);
	if(hotel!=null) {
		return ResponseEntity.ok(hotel); 
	}
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not available with ID");
		
	}
	
	@GetMapping("/gethotel")
	public List<HotelModel> getHotelDe()
	{
		return hser.getDetails();
	}
	
}
