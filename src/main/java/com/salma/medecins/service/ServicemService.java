package com.salma.medecins.service;

import java.util.List;

import com.salma.medecins.entities.Servicem;

import org.springframework.data.domain.Page;

public interface ServicemService {
	List<Servicem> getAllServicems();

	Servicem saveServicem(Servicem categorie);
	Page<Servicem> getAllServicemsParPage(int page, int size);
	void deleteServicemById(Long id);
	Servicem getServicem(Long id);
	
	Servicem updateServicem(Servicem s);

}
