package com.salma.medecins.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.UniqueElements;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Servicem {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idSer;

private String nomSer;
private String descriptionSer;
@JsonIgnore
@OneToMany(mappedBy = "servicem")
private List<Medecin> meds;
public Long getIdSer() {
	return idSer;
}
public void setIdSer(Long idSer) {
	this.idSer = idSer;
}
public String getNomSer() {
	return nomSer;
}
public void setNomSer(String nomSer) {
	this.nomSer = nomSer;
}
public String getDescriptionSer() {
	return descriptionSer;
}
public void setDescriptionSer(String descriptionSer) {
	this.descriptionSer = descriptionSer;
}
public List<Medecin> getmeds() {
	return meds;
}
public void setmeds(List<Medecin> meds) {
	this.meds = meds;
}

}

