package com.app.projet.service;

import java.util.Date;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.projet.model.Boulangerie;
import com.app.projet.model.Restaurant;
import com.app.projet.repository.BoulangerieRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Service

public class BoulangerieServiceImpl implements BoulangerieService{
    @Autowired
    private BoulangerieRepository BoulangerieRepository;
	@Override
	public List<Boulangerie> getAllBoulangerie() {
		// TODO Auto-generated method stub
		return BoulangerieRepository.findAll();
	}
	
	
	@Override
	public void saveBoulangerie(Boulangerie boulangerie) {
		// TODO Auto-generated method stub
		this.BoulangerieRepository.save(boulangerie);
	}


	@Override
	public Boulangerie getBoulangerieById(long id) {
		// TODO Auto-generated method stub
		Optional<Boulangerie> optional = BoulangerieRepository.findById(id);
		Boulangerie boulangerie = null;
		if (optional.isPresent()) {
			boulangerie = optional.get();
		} else {
			throw new RuntimeException(" Boulangerie not found for id :: " + id);
		}
		return boulangerie;
	}


	@Override
	public void deleteBoulangerieById(long id) {
		// TODO Auto-generated method stub
		this.BoulangerieRepository.deleteById(id);
	}


	@Override
	public String AfficherMsg(long id) {
		// TODO Auto-generated method stub
		return "une association vous demande l'offre qui a l'id="+id+ " ";
	}


	
	
	@Override
	public Page<Boulangerie> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.BoulangerieRepository.findAll(pageable);
	}


	@Override
	public long count() {
		// TODO Auto-generated method stub
		return this.BoulangerieRepository.count();
	}

	
	@Override
	public Boulangerie FindByEmail(String s) {
		Boulangerie g=new Boulangerie();
		for (Boulangerie b: this.BoulangerieRepository.findAll()) {
			if(b.getEmail().equalsIgnoreCase(s)) {
				g=b;
			}
			else g=null;	
		}
		return g;
	}

	
	
	
	
	
	
	

}
