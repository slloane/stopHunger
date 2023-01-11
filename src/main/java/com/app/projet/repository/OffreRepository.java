package com.app.projet.repository;

import java.util.Date;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

import com.app.projet.model.Offre;

@Repository
public interface OffreRepository extends  JpaRepository<Offre, Long>{

	/*List<Offre> findByBoulangerieId(Long Id);
	  
	  @Transactional
	  void deleteByBoulangerieId(long Id);*/
	

	

	//List<Offre> findAllByDate_Expiration(Date dateExpiration);

}
