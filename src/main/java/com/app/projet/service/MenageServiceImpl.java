package com.app.projet.service;

import java.util.Date;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.projet.model.Boulangerie;
import com.app.projet.model.Menage;
import com.app.projet.repository.MenageRepository;
import org.springframework.data.domain.Sort;

@Service

public class MenageServiceImpl implements MenageService{
    @Autowired
    private MenageRepository MenageRepository;
	@Override
	public List<Menage> getAllMenage() {
		// TODO Auto-generated method stub
		return MenageRepository.findAll();
	}
	
	
	@Override
	public void saveMenage(Menage Menage) {
		// TODO Auto-generated method stub
		this.MenageRepository.save(Menage);
	}


	@Override
	public Menage getMenageById(long id) {
		// TODO Auto-generated method stub
		Optional<Menage> optional = MenageRepository.findById(id);
		Menage Menage = null;
		if (optional.isPresent()) {
			Menage = optional.get();
		} else {
			throw new RuntimeException(" Menage not found for id :: " + id);
		}
		return Menage;
	}


	@Override
	public void deleteMenageById(long id) {
		// TODO Auto-generated method stub
		this.MenageRepository.deleteById(id);
	}


	@Override
	public long count() {
		// TODO Auto-generated method stub
		return this.MenageRepository.count();
	}


	@Override
	public Menage FindByEmail(String s) {
		
			Menage g = new Menage();
			for (Menage b: this.MenageRepository.findAll()) {
				if(b.getEmail().equalsIgnoreCase(s)) {
					g=b;
				}
				else g=null;	
			}
			return g;
		
	}


	
	
	
	
	
	
	

}
