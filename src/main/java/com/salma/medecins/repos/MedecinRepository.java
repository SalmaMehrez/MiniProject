package com.salma.medecins.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.salma.medecins.entities.Medecin;
import com.salma.medecins.entities.Servicem;
@RepositoryRestResource(path = "rest")
public interface MedecinRepository extends JpaRepository<Medecin, Long> {
	List<Medecin> findByNomMedecin(String nom);
	List<Medecin> findByNomMedecinContains(String nom);
	@Query("select m from Medecin m where m.nomMedecin like %?1 and m.specialiteMedecin > ?2")
	List<Medecin> findByNomSpecialite (String nom, String specialite);
	@Query("select m from Medecin m where m.servicem = ?1")
	List<Medecin> findByServicem (Servicem servicem);
	List<Medecin> findByServicemIdSer(Long id);
	List<Medecin> findByOrderByNomMedecinAsc();
	
}
