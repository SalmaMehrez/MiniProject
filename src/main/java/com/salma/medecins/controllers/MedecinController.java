package com.salma.medecins.controllers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salma.medecins.entities.Servicem;
import com.salma.medecins.entities.Medecin;
import com.salma.medecins.service.ServicemService;
import com.salma.medecins.service.MedecinService;

@Controller
public class MedecinController {
	@Autowired
	MedecinService medecinService;
	@Autowired
	ServicemService servicemService;

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		List<Servicem> sers = servicemService.getAllServicems();
		Medecin med = new Medecin();
		Servicem ser = new Servicem();
		ser = sers.get(0); // prendre la première catégorie de la liste
		med.setServicem(ser); // affedter une catégorie par défaut au medecin pour éviter le pb avec une
								// catégorie null
		modelMap.addAttribute("medecin", med);
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("categories", sers);
		return "formMedecin";
	}

	@RequestMapping("/saveMedecin")
	public String saveMedecin(@Valid Medecin medecin, BindingResult bindingResult) {
		System.out.println(medecin);
		System.out.println(bindingResult.getAllErrors());
		if (bindingResult.hasErrors())
			return "formMedecin";

		medecinService.saveMedecin(medecin);
		return "formMedecin";
	}

	@RequestMapping("/ListeMedecins")
	public String listemedecins(ModelMap modelMap,

			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size)

	{
		Page<Medecin> medecins = medecinService.getAllMedecinsParPage(page, size);
		modelMap.addAttribute("medecins", medecins);
		modelMap.addAttribute("pages", new int[medecins.getTotalPages()]);
		Page<Servicem> sers = servicemService.getAllServicemsParPage(page, size);
		modelMap.addAttribute("servicems", sers);
		modelMap.addAttribute("pages", new int[sers.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("currentPage", page);

		return "listeMedecins";
	}

	@RequestMapping("/supprimerMedecin")
	public String supprimerMedecin(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "4") int size) {
		medecinService.deleteMedecinById(id);
		Page<Medecin> meds = medecinService.getAllMedecinsParPage(page, size);
		modelMap.addAttribute("medecins", meds);
		modelMap.addAttribute("pages", new int[meds.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeMedecins";
	}

	@RequestMapping("/modifierMedecin")
	public String editerMedecin(@RequestParam("id") Long id, ModelMap modelMap) {
		Medecin m = medecinService.getMedecin(id);
		List<Servicem> sers = servicemService.getAllServicems();
		modelMap.addAttribute("medecin", m);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("servicems", sers);
		return "formMedecin";
	}

	@RequestMapping("/updateMedecin")
	public String updateMedecin(@ModelAttribute("medecin") Medecin medecin,
	@RequestParam("date") String date,ModelMap modelMap) throws ParseException

{
//conversion de la date

SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
Date dateNaissance = dateformat.parse(String.valueOf(date));
medecin.setDateNaissance(dateNaissance);
medecinService.updateMedecin(medecin);
List<Medecin> meds = medecinService.getAllMedecins();
modelMap.addAttribute("etudiants", meds);
List<Servicem> sers = servicemService.getAllServicems();
modelMap.addAttribute("servicems", sers);
return "listeMs";

}
	@RequestMapping("/chercherSer")
	  public String chercherSer(@RequestParam("idSer") int idSer,
	    		ModelMap modelMap,
	    		@RequestParam (name="page",defaultValue = "0") int page,
	    		@RequestParam (name="size", defaultValue = "2") int size)
	    {     
		 	
	    	  List <Medecin> medecins = medecinService.getAllMedecins();
	    	  medecins = medecins.stream()
	                  .filter(x -> x.getServicem().getIdSer() == idSer)
	                  .collect(Collectors.toList());
	    	  modelMap.addAttribute("medecins",medecins);
	    	  Page<Servicem> sers = servicemService.getAllServicemsParPage(page, size);
	    		modelMap.addAttribute("servicems", sers);
	    		modelMap.addAttribute("pages", new int[sers.getTotalPages()]);
	    		modelMap.addAttribute("currentPage", page);
	    	  
	    	  return "listeMedecins";
	    }  
	@RequestMapping("/chercherNom")
    public String chercherNom(@RequestParam("nomMedecin") String nom,
    		ModelMap modelMap,
    		@RequestParam (name="page",defaultValue = "0") int page,
    		@RequestParam (name="size", defaultValue = "10") int size)
    
    
    {     
	 	
    	  List <Medecin> meds = medecinService.findByNomMedecinContains(nom);
    	  
    	  modelMap.addAttribute("Medecins",meds);
    	  List<Servicem> sers = servicemService.getAllServicems();
    		modelMap.addAttribute("servicems", sers);
    	  /*Page<Etudiant> prod = etudiantService.getAllEtudiantsParPage(page, size);
    		modelMap.addAttribute("Etudiants", prod);
    		modelMap.addAttribute("pages", new int[prod.getTotalPages()]);
    		modelMap.addAttribute("currentPage", page);*/
    	  return "resultat";
    }  
}