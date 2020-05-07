package com.cg.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.entity.Airport;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class FMSDao {
	
	
	@PersistenceContext
	EntityManager em;
	
	
	//Add airport to the database.
		public String addAirport(Airport a)
		{
			em.persist(a);
			return "flight added successfully";
		}
		
		//View  all Airport details 
		public List<Airport> viewAirport()
		{
			Query query=em.createQuery("Select a from Airport a");
			return query.getResultList();
		}
		
		
		//View Airport details using the relevant airport code
		public Airport viewAirport(String airportCode)
		{
			List<Airport> list=viewAirport();
			Airport airport=null;
			Optional <Airport> optional=list.stream().
					filter(a1->a1.getAirportCode().equals(airportCode)).findFirst();
					if(optional.isPresent()) {
						airport=optional.get();
					}
			return airport;
			
		}
		
		//Delete Airport details
		public String deleteAirport(String airportCode) {
			em.remove(viewAirport(airportCode));
			return "Airport Deleted Successfully";
		}
		
		//modify Airport details
		public String modifyAirport(Airport airport) {
			em.merge(airport);
			return "Updated successfully";
		}

}
