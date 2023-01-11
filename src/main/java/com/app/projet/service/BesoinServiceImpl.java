package com.app.projet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.projet.model.Besoin;
import com.app.projet.repository.BesoinRepository;


@Service
public class BesoinServiceImpl implements BesoinService {
	
	@Autowired
	private BesoinRepository besoinRepository;

	@Override
	public List<Besoin> getAllBesoins() {
		return besoinRepository.findAll();
	}

	@Override
	public void saveBesoin(Besoin b) {
		this.besoinRepository.save(b);
		
	}

	@Override
	public Besoin getBesoinById(long id) {
		Optional<Besoin> optional = besoinRepository.findById(id);
		Besoin besoin = null;
		if(optional.isPresent()) {
			besoin = optional.get();
			
		}
		else {
			throw new RuntimeException("Besoin d'id : "+id+"est introuvable");
		}
		return besoin;
	}

	@Override
	public void deleteBesoinById(long id) {
		this.besoinRepository.deleteById(id);
		
	}
	

}
