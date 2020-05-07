package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Airport;
import com.cg.exception.FMSException;
import com.cg.service.FMSService;

@Component
@RestController
public class FMSController {
	
	@Autowired
	FMSService fmsService;
	
	@PostMapping(value="/airport/addAirport",consumes= {"application/json"})
	public String addAirport(@RequestBody Airport airport) {
		return fmsService.addAirport(airport);
		
	}

	@CrossOrigin
	@GetMapping(value="/airport/viewAirport")
	public List<Airport> viewAirport(){
		return fmsService.viewAirport();
	}
	
	@GetMapping(value="/airport/viewAirport/{airportCode}")
	public Airport viewAirport(@PathVariable String airportCode) {
		return fmsService.viewAirport(airportCode);
	}
	
	@DeleteMapping(value="/airport/deleteAirport/{airportCode}")
	public String deleteAirport(@PathVariable String airportCode) {
		return fmsService.deleteAirport(airportCode);
	}
	

	@PutMapping(value="/airport/modifyairport",consumes= {"application/json"})
	public String modifyAirportt(@RequestBody Airport airport) throws FMSException{
		return fmsService.modifyAirport(airport);
	}

}
