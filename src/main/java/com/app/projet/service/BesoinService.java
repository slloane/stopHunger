package com.app.projet.service;

import java.util.ArrayList;
import java.util.List;

import com.app.projet.model.Besoin;

public interface BesoinService {
	List<Besoin> getAllBesoins();
	void saveBesoin(Besoin b);
	Besoin getBesoinById(long id);
	void deleteBesoinById(long id2);

}
