package com.app.projet.service;

import java.util.Date;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.projet.model.Offre;
import com.app.projet.repository.OffreRepository;

import org.springframework.data.domain.Sort;

@Service

public class OffreServiceImpl implements OffreService{
    @Autowired
    private OffreRepository offreRepository;
	@Override
	public List<Offre> getAllOffre() {
		// TODO Auto-generated method stub
		return offreRepository.findAll();
	}
	
	
	@Override
	public void saveOffre(Offre offre) {
		// TODO Auto-generated method stub
		this.offreRepository.save(offre);
	}


	@Override
	public Offre getOffreById(long id) {
		// TODO Auto-generated method stub
		Optional<Offre> optional = offreRepository.findById(id);
		Offre offre = null;
		if (optional.isPresent()) {
			offre = optional.get();
		} else {
			throw new RuntimeException(" offre not found for id :: " + id);
		}
		return offre;
	}


	@Override
	public void deleteOffreById(long id) {
		// TODO Auto-generated method stub
		this.offreRepository.deleteById(id);
	}


	@Override
	public String AfficherMsg(long id) {
		// TODO Auto-generated method stub
		return "une association vous demande l'offre qui a l'id="+id+ " ";
	}


	@Override
	public long count() {
		// TODO Auto-generated method stub
		return this.offreRepository.count();	
		}
	
	
	
	
	
	

}
