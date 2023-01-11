package com.app.projet.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.app.projet.model.Boulangerie;
import com.app.projet.model.Restaurant;

public interface BoulangerieService {
	List<Boulangerie> getAllBoulangerie();
	void saveBoulangerie(Boulangerie boulangerie);
	Boulangerie getBoulangerieById(long id);
	void deleteBoulangerieById(long id);
	String AfficherMsg(long id);
	Page<Boulangerie> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	long count();
	Boulangerie FindByEmail(String s);
}
