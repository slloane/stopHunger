package com.app.projet.repository;

import java.util.Date;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.projet.model.Restaurant;

@Repository
public interface RestaurantRepository extends  JpaRepository<Restaurant, Long>{



}
