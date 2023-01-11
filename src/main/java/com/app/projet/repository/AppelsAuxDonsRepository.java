package com.app.projet.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.projet.model.AppelsAuxDons;

@Repository
public interface AppelsAuxDonsRepository extends JpaRepository<AppelsAuxDons, Long>{

}
