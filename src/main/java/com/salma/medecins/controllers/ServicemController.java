package com.salma.medecins.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.salma.medecins.entities.Servicem;
import com.salma.medecins.entities.Medecin;
import com.salma.medecins.service.ServicemService;
import com.salma.medecins.service.MedecinService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ServicemController {
	  @Autowired
	    ServicemService servicemService;
	  @Autowired
	    MedecinService etudService;
	 @RequestMapping("/CreateServicem")
	  public String CreateSer(ModelMap modelMap)
	    {
	  
	    modelMap.addAttribute("servicem",new Servicem());
	    modelMap.addAttribute("mode","new");
	    
	    return "formServicem";
	    }
	 
	 @RequestMapping("/saveServicem")
	    public String saveServicem(Servicem servicem)
	    {
	    servicemService.saveServicem(servicem);
		return "redirect:/ListeServicem";
	    }
	 
	 @RequestMapping("/ListeServicem")
	    public String listeServicems(ModelMap modelMap,
	    		@RequestParam (name="page",defaultValue = "0") int page,
	    		@RequestParam (name="size", defaultValue = "2") int size)
	    {
	    	Page<Servicem> sers = servicemService.getAllServicemsParPage(page, size);
	    	modelMap.addAttribute("servicems", sers);
	    	modelMap.addAttribute("pages", new int[sers.getTotalPages()]);
	    	modelMap.addAttribute("currentPage", page);
	    	return "listeservicem";
	    }
	 
	 
	 @RequestMapping("/supprimerServicem")
	    public String supprimerSkin(@RequestParam("id") Long id,
	    		ModelMap modelMap,
	    		@RequestParam (name="page",defaultValue = "0") int page,
	    		@RequestParam (name="size", defaultValue = "2") int size)
	    {
	        servicemService.deleteServicemById(id);
	        Page<Servicem> sers = servicemService.getAllServicemsParPage(page,size);
	        		modelMap.addAttribute("servicems", sers);
	        		modelMap.addAttribute("pages", new int[sers.getTotalPages()]);
	        		modelMap.addAttribute("currentPage", page);
	        		modelMap.addAttribute("size", size);
	        		return "listeServicem";
	    }
	 @RequestMapping("/modifierServicem")
	    public String editerServicem(@RequestParam("id") Long id,ModelMap modelMap)
	    {
	    Servicem s= servicemService.getServicem(id);
	    modelMap.addAttribute("servicem", s);
	    modelMap.addAttribute("mode", "edit");
	    return "formServicem";
	    }
	 
	 
	 @RequestMapping("/updateServicem")
	    public String updateServicem(@ModelAttribute("servicem") Servicem servicem,ModelMap modelMap) throws ParseException
	    {

	        servicemService.updateServicem(servicem);
	        List<Servicem> sers = servicemService.getAllServicems();
	        modelMap.addAttribute("servicems", sers);
	        return "listeServicem";
	    }
	 @RequestMapping("/chercherServicem")
	
	    public String chercherServicem(@RequestParam("nomSer") String nom,
	    		ModelMap modelMap)
	    
	    
	    {      
		 
		 		System.out.println(nom);
	    	  List <Medecin> meds = etudService.findByNomServicemContains(nom);
	    	  System.out.println(meds);
	    	  modelMap.addAttribute("servicems",meds);
	    	  
	    	  return "chercherSer";
	    } 


}
