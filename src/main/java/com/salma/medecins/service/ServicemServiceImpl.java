package com.salma.medecins.service;

import java.util.List;

import com.salma.medecins.entities.Servicem;
import com.salma.medecins.repos.ServicemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public  class ServicemServiceImpl implements ServicemService {
	@Autowired
	ServicemRepository servicemRepository;
	
	@Override
	public List<Servicem> getAllServicems() {
		return servicemRepository.findAll();
	}
	 @Override
	    public Servicem saveServicem(Servicem servicem) {
	        return servicemRepository.save(servicem);
	    }
	 @Override
	    public Page<Servicem> getAllServicemsParPage(int page, int size) {
	    return servicemRepository.findAll(PageRequest.of(page, size));
	    }
	 
	 @Override
	    public void deleteServicemById(Long id) {
	        servicemRepository.deleteById(id);
	    }
	 
	 @Override
	    public Servicem getServicem(Long id) {
	        return servicemRepository.findById(id).get();
	    }
	 @Override
	    public Servicem updateServicem(Servicem c) {
	        return servicemRepository.save(c);
	    }


}
