package com.app.projet.service;

import java.util.Date;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.projet.model.Association;
import com.app.projet.model.Restaurant;
import com.app.projet.repository.AssociationRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Service

public class AssociationServiceImpl implements AssociationService{
    @Autowired
    private AssociationRepository AssociationRepository;
	@Override
	public List<Association> getAllAssociation() {
		// TODO Auto-generated method stub
		return AssociationRepository.findAll();
	}
	
	
	@Override
	public void saveAssociation(Association Association) {
		// TODO Auto-generated method stub
		this.AssociationRepository.save(Association);
	}


	@Override
	public Association getAssociationById(long id) {
		// TODO Auto-generated method stub
		Optional<Association> optional = AssociationRepository.findById(id);
		Association Association = null;
		if (optional.isPresent()) {
			Association = optional.get();
		} else {
			throw new RuntimeException(" Association not found for id :: " + id);
		}
		return Association;
	}


	


	@Override
	public void deleteAssociationById(long id) {
		this.AssociationRepository.deleteById(id);
	}


	@Override
	public long count() {
		// TODO Auto-generated method stub
		return this.AssociationRepository.count();
	}
	
	@Override
	public Page<Association> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.AssociationRepository.findAll(pageable);
	}


	@Override
	public Association FindByEmail(String s) {
		Association g = new Association();
		for (Association b: this.AssociationRepository.findAll()) {
			if(b.getEmail().equalsIgnoreCase(s)) {
				g=b;
			}
			else g=null;	
		}
		return g;
	}
	
	
	
	

}
