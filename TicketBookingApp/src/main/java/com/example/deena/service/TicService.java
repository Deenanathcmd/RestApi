package com.example.deena.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.deena.model.TicBook;
import com.example.deena.repository.TicRepo;

@Service
public class TicService {
	@Autowired
	public TicRepo apprepo;
	
	//post data
	public String saveApp(TicBook a)
	{
		apprepo.save(a);
		return "Data is saved to database";
	}
	
	//get data
	public List<TicBook> getApp()
	{
		return apprepo.findAll();
	}
	
	//update the data
	public TicBook updateApp(TicBook hma)
	{
		return apprepo.saveAndFlush(hma);
	}
	
	//delete the data
	public void deleteApp(int id)
	{
		System.out.println("Deleted");
		apprepo.deleteById(id);
	}
	
	public boolean deleteappinfo(int appId)
	{
		if(apprepo.existsById(appId))
		{
			apprepo.deleteById(appId);
			return true;
		}
		return false;
	}
	
	public Optional<TicBook> getUserId(int userId)
	   {
		   Optional<TicBook>app=apprepo.findById(userId);
		   if(app.isPresent())
		   {
			   return app;
		   }
		   return null;
	   }
	}