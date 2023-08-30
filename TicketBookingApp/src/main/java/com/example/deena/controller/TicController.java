package com.example.deena.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.deena.model.TicBook;
import com.example.deena.service.TicService;

@RestController
public class TicController {
	@Autowired
	public TicService appserv;
	
	//post mapping
	@PostMapping("/postApp")
	public String postApp(@RequestBody TicBook hma)
	{
		appserv.saveApp(hma);
		return "Data saved";
	}
	
	//get mapping
	@GetMapping("/getApp")
	public List<TicBook> getAppInfo()
	{
		return appserv.getApp();
	}
	
	//put mapping
	@PutMapping("/updateApp")
	public TicBook updateAppInfo(@RequestBody TicBook hx )
	{
		return appserv.updateApp(hx);
	}
	
	//put mapping with id
	@PutMapping("/updatenew/{id}")
	
		public String updateAppinfo(@RequestBody TicBook hnew, @PathVariable int id)
		{
			appserv.updateApp(hnew);
			return "App with Id "+hnew.getTicId()+" is updated";
		}
	
	
	
	//delete mapping using path variable
	@DeleteMapping("/deleteApp/{id}")
	public String removeApp(@PathVariable("id") int hd)
	{
		appserv.deleteApp(hd);
		return "App with Id "+hd+" is deleted";
	}
	
	//delete mapping using request param
	@DeleteMapping("/byReqParm")
	public String removeByRequestPam(@RequestParam("id") int id)
	{ 
		appserv.deleteApp(id);
		return "App with Id "+id+" is deleted"; 
	}
	
	
	//delete mapping with present or not
	@DeleteMapping("/deleteappif/{id}")
	public ResponseEntity<String>deleteappinfo(@PathVariable int id)
	{
		boolean deleted=appserv.deleteappinfo(id);
		if(deleted)
		{
			return ResponseEntity.ok("App with ID "+ id +" deleted successfully");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("App with ID "+ id +" not found");
		}
	}
	
	//getuserById
		@GetMapping("/users/{userId}")
		public ResponseEntity<?>getUserId(@PathVariable int userId)
		{
		Optional<TicBook>app=appserv.getUserId(userId);
		if(app!=null) {
			return ResponseEntity.ok(app); //return the users data if available
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not available with ID");
			
		}
}