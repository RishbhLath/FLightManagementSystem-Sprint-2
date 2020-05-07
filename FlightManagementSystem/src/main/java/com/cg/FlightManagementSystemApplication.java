package com.cg;
import com.cg.dao.FMSDao;
import com.cg.entity.Airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlightManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FlightManagementSystemApplication.class, args);
	}

	@Autowired
	FMSDao fmsdao;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("wecpme");
		
		Airport airport=new Airport("224","IGI","DELHI");
		fmsdao.addAirport(airport);
		Airport airport1=new Airport("234","SHIVAJI","PUNE");
		fmsdao.addAirport(airport1);
		
	
		
	}

}
