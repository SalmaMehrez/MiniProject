package com.salma.medecins.repos;

import java.util.List;

import com.salma.medecins.entities.Servicem;
import com.salma.medecins.entities.Medecin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource(path = "rest")
public interface ServicemRepository extends JpaRepository<Servicem, Long> {

	
}
