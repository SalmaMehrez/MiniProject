package com.salma.medecins.entities;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Medecin {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idMedecin;
@NotNull
@Size (min = 4,max = 15)
private String nomMedecin;
private String specialiteMedecin;
@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "yyyy-MM-dd")
@PastOrPresent
private Date dateNaissance;
@ManyToOne
private Servicem servicem;
public Medecin() {
super();
}
public Medecin(String nomMedecin,String specialiteMedecin, Date dateNaissance) {
super();
this.nomMedecin = nomMedecin;
this.specialiteMedecin = specialiteMedecin;
this.dateNaissance = dateNaissance;
}
public Long getIdMedecin() {
return idMedecin;
}
public void setIdMedecin(Long idMedecin) {
this.idMedecin = idMedecin;
}
public String getNomMedecin() {
return nomMedecin;
}
public void setNomMedecin(String nomMedecin) {
this.nomMedecin = nomMedecin;
}
public String getSpecialiteMedecin() {
return specialiteMedecin;
}
public void setSpecialiteMedecin(String specialiteMedecin) {
this.specialiteMedecin = specialiteMedecin;
}
public Date getDateNaissance() {
return dateNaissance;
}
public void setDateNaissance(Date dateNaissance) {
this.dateNaissance = dateNaissance;
}
@Override
public String toString() {
return "Medecin [idMedecin=" + idMedecin + ", nomMedecin=" +

nomMedecin + ", specialiteMedecin=" + specialiteMedecin

+ ", dateNaissance=" + dateNaissance + "]";

}
public Servicem getServicem() {
	return this.servicem;
}
public void setServicem(Servicem cat) {
	// TODO Auto-generated method stub
	
}
}