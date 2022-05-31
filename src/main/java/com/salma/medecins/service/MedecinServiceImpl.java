package com.salma.medecins.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.salma.medecins.entities.Medecin;
import com.salma.medecins.entities.Servicem;
import com.salma.medecins.repos.MedecinRepository;
@Service
public class MedecinServiceImpl implements MedecinService {
@Autowired
MedecinRepository medecinRepository;
MedecinService medecinService;
@Override
public Medecin saveMedecin(Medecin m) {
	return medecinRepository.save(m);
	}
	@Override
	public Medecin updateMedecin(Medecin m) {
	return medecinRepository.save(m);
	}
	@Override
	public void deleteMedecin(Medecin m) {
	medecinRepository.delete(m);
	}
	@Override
	public void deleteMedecinById(Long id) {
	medecinRepository.deleteById(id);
	}
	@Override
	public Medecin getMedecin(Long id) {
	return medecinRepository.findById(id).get();
	}
	@Override
	public List<Medecin> getAllMedecins() {
	return medecinRepository.findAll();
	}
	
	public void testFindByNomMedecinContains()
	{
	
	Page<Medecin> meds = medecinService.getAllMedecinsParPage(0,2);
	System.out.println(meds.getSize());
	System.out.println(meds.getTotalElements());
	System.out.println(meds.getTotalPages());
	meds.getContent().forEach(m -> {System.out.println(m.toString());
	});
		}
	@Override
	public Page<Medecin> getAllMedecinsParPage(int page, int size) {
		return medecinRepository.findAll(PageRequest.of(page, size));
	}
	@Override
	public List<Medecin> findByNomMedecin(String nom) {
	return medecinRepository.findByNomMedecin(nom);
	}
	@Override
	public List<Medecin> findByNomMedecinContains(String nom) {
	return medecinRepository.findByNomMedecinContains(nom);
	}
	@Override
	public List<Medecin> findByNomSpecialite(String nom, String specialite) {
		return medecinRepository.findByNomSpecialite(nom, specialite);
	}
	@Override
	public List<Medecin> findByServicem(Servicem servicem) {
	return medecinRepository.findByServicem(servicem);
	}
	@Override
	public List<Medecin> findByServicemIdSer(Long id) {
	return medecinRepository.findByServicemIdSer(id);
	}
	@Override
	public List<Medecin> findByOrderByNomMedecinAsc() {
	return medecinRepository.findByOrderByNomMedecinAsc();
	}
	@Override
	public List<Medecin> trierMedecinsNomsSpecialite() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Medecin> findByNomServicemContains(String nom) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	}
	