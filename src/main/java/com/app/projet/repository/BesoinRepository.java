package com.app.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.projet.model.Besoin;

@Repository
public interface BesoinRepository extends JpaRepository<Besoin,Long> {
	

}
