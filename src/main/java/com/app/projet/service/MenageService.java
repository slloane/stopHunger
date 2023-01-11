package com.app.projet.service;

import java.util.List;

import com.app.projet.model.Boulangerie;
import com.app.projet.model.Menage;

public interface MenageService {
	List<Menage> getAllMenage();
	void saveMenage(Menage Menage);
	Menage getMenageById(long id);
	void deleteMenageById(long id);
	long count();
	Menage FindByEmail(String s);
}