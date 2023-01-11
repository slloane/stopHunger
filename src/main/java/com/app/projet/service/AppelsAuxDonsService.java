package com.app.projet.service;


import java.util.List;

import org.springframework.data.domain.Page;

import com.app.projet.model.AppelsAuxDons;

public interface AppelsAuxDonsService {
	List<AppelsAuxDons> getAllAppelsAuxDons();
	void saveAppelsAuxDons(AppelsAuxDons AppelsAuxDons);
	AppelsAuxDons getAppelsAuxDonsById(long id);
	void deleteAppelsAuxDonsById(long id);
	Page<AppelsAuxDons> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	long count();
}