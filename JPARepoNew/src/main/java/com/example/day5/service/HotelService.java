package com.example.day5.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.day5.model.HotelModel;
import com.example.day5.repository.HotelRepo;
@Service
public class HotelService {
	@Autowired
	HotelRepo hrepo;
	
	public HotelModel saveDetails(HotelModel hm) {
		return hrepo.save(hm);
	}
	public HotelModel updateDetails(HotelModel hm) {
		return hrepo.saveAndFlush(hm);
	}
	public void delete(int HotelId) {
		System.out.print("Deleted");
		hrepo.deleteById(HotelId);
	}
	public boolean deleteHotel(int hotelId) {
		if(hrepo.existsById(hotelId)) {
			hrepo.deleteById(hotelId);
			return true;
		}
		return false;
	}
	public Optional<HotelModel> getUserId(int userId)
	   {
		   Optional<HotelModel>hotel=hrepo.findById(userId);
		   if(hotel.isPresent())
		   {
			   return hotel;
		   }
		   return null;
	   }
	
	public List<HotelModel> getDetails()
	{
		return hrepo.findAll();
	}
}
