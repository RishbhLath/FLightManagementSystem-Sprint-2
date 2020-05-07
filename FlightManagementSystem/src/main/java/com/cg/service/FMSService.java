package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.FMSDao;
import com.cg.entity.Airport;
import com.cg.entity.Airport;
import com.cg.exception.FMSException;

@Service
public class FMSService {
	
	@Autowired
	private FMSDao flightDao;
	
	public String addAirport(Airport a) {
		return flightDao.addAirport(a);
	}
	
	public List<Airport> viewAirport(){
		return flightDao.viewAirport();
	}
	
	public Airport viewAirport(String airportCode) {
		return flightDao.viewAirport(airportCode);
	}	
	
	public String deleteAirport(String airportCode) {
		return flightDao.deleteAirport(airportCode);
	}
	
	public String modifyAirport(Airport airport) throws FMSException{
		String airportCode=airport.getAirportCode();
		
		Airport airport1=viewAirport(airportCode);
		
		if(airport1!=null)
		{
		
		  flightDao.modifyAirport(airport);
		  return "Airport Details Updated Successfully";
		 
		}
		else
		{
			throw new FMSException("Airport Code do not exist in the database");
		}
		
	}
	

	}
