package com.app.projet.service;

import java.util.List;

import com.app.projet.model.Offre;

public interface OffreService {
	List<Offre> getAllOffre();
	void saveOffre(Offre offre);
	Offre getOffreById(long id);
	void deleteOffreById(long id);
	String AfficherMsg(long id);
	 long count();

}
