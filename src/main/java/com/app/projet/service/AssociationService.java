package com.app.projet.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.app.projet.model.Association;
import com.app.projet.model.Restaurant;

public interface AssociationService {
	List<Association> getAllAssociation();
	void saveAssociation(Association Association);
	Association getAssociationById(long id);
	void deleteAssociationById(long id);
	Page<Association> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	long count();
	Association FindByEmail(String s);
}
