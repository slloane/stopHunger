package com.app.projet.service;

import java.util.Date;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.projet.model.AppelsAuxDons;
import com.app.projet.model.Menage;
import com.app.projet.model.Restaurant;
import com.app.projet.repository.RestaurantRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Service

public class RestaurantServiceImpl implements RestaurantService{
    @Autowired
    private RestaurantRepository RestaurantRepository;
	@Override
	public List<Restaurant> getAllRestaurant() {
		// TODO Auto-generated method stub
		return RestaurantRepository.findAll();
	}
	
	
	@Override
	public void saveRestaurant(Restaurant Restaurant) {
		// TODO Auto-generated method stub
		this.RestaurantRepository.save(Restaurant);
	}


	@Override
	public Restaurant getRestaurantById(long id) {
		// TODO Auto-generated method stub
				Optional<Restaurant> optional = RestaurantRepository.findById(id);
				Restaurant Restaurant = null;
				if (optional.isPresent()) {
					Restaurant = optional.get();
				} else {
					throw new RuntimeException(" Restaurant not found for id :: " + id);
				}
				return Restaurant;
	}


	@Override
	public void deleteRestaurantById(long id) {
		// TODO Auto-generated method stub
				this.RestaurantRepository.deleteById(id);
		
	}
	
	@Override
	public Page<Restaurant> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.RestaurantRepository.findAll(pageable);
	}


	@Override
	public long count() {
		// TODO Auto-generated method stub
		return this.RestaurantRepository.count();
	}


	@Override
	public Restaurant FindByEmail(String s) {
		Restaurant g = new Restaurant();
		for (Restaurant b: this.RestaurantRepository.findAll()) {
			if(b.getEmail().equalsIgnoreCase(s)) {
				g=b;
			}
			else g=null;	
		}
		return g;
	
	}


	
	
	
	
	
	

}
