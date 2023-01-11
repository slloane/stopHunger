package com.app.projet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.app.projet.model.AppelsAuxDons;
import com.app.projet.repository.*;

@Service
public class AppelsAuxDonsServiceImpl implements AppelsAuxDonsService {

	@Autowired
	private AppelsAuxDonsRepository AppelsAuxDonsRepository;

	@Override
	public List<AppelsAuxDons> getAllAppelsAuxDons() {
		return AppelsAuxDonsRepository.findAll();
	}

	@Override
	public void saveAppelsAuxDons(AppelsAuxDons AppelsAuxDons) {
		this.AppelsAuxDonsRepository.save(AppelsAuxDons);
	}

	@Override
	public AppelsAuxDons getAppelsAuxDonsById(long id) {
		Optional<AppelsAuxDons> optional = AppelsAuxDonsRepository.findById(id);
		AppelsAuxDons AppelsAuxDons = null;
		if (optional.isPresent()) {
			AppelsAuxDons = optional.get();
		} else {
			throw new RuntimeException(" Appel Aux Dons not found for id :: " + id);
		}
		return AppelsAuxDons;
	}

	@Override
	public void deleteAppelsAuxDonsById(long id) {
		this.AppelsAuxDonsRepository.deleteById(id);
	}

	@Override
	public Page<AppelsAuxDons> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.AppelsAuxDonsRepository.findAll(pageable);
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return this.AppelsAuxDonsRepository.count();
	}
}