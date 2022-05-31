package com.salma.medecins.service;
import java.util.List;

import org.springframework.data.domain.Page;

import com.salma.medecins.entities.Medecin;
import com.salma.medecins.entities.Servicem;
public interface MedecinService {
Medecin saveMedecin(Medecin p);
Medecin updateMedecin(Medecin p);
void deleteMedecin(Medecin p);
void deleteMedecinById(Long id);
Medecin getMedecin(Long id);
List<Medecin> getAllMedecins();
Page<Medecin> getAllMedecinsParPage(int page, int size);

List<Medecin> findByNomMedecin(String nom);
List<Medecin> findByNomMedecinContains(String nom);
List<Medecin> findByNomSpecialite (String nom, String specialite);

List<Medecin> findByOrderByNomMedecinAsc();
List<Medecin> trierMedecinsNomsSpecialite();
List<Medecin> findByServicemIdSer(Long id);
List<Medecin> findByServicem(Servicem servicem);
List<Medecin> findByNomServicemContains(String nom);
}