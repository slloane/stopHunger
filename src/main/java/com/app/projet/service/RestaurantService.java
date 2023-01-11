package com.app.projet.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.app.projet.model.AppelsAuxDons;
import com.app.projet.model.Menage;
import com.app.projet.model.Restaurant;

public interface RestaurantService {
	List<Restaurant> getAllRestaurant();
	void saveRestaurant(Restaurant Restaurant);
	Restaurant getRestaurantById(long id);
	void deleteRestaurantById(long id);
	Page<Restaurant> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	long count();
	Restaurant FindByEmail(String s);
}