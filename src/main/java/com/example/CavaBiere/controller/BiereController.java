package com.example.CavaBiere.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.example.CavaBiere.FileUploadUtil;
import com.example.CavaBiere.bo.Biere;
import com.example.CavaBiere.dal.BiereRepository;
import com.example.CavaBiere.service.BiereService;

@Controller
public class BiereController {

	//Lien avec la couche service
	@Autowired
	private BiereService biereService;
	
	@Autowired
	
	public BiereController(BiereService biereService) {
		super();
		this.biereService = biereService;}
	
	@Autowired
    private BiereRepository biereRepo;

	@GetMapping("/liste")
	public String afficherListe(Model model) {
		model.addAttribute("liste", biereService.getBieres());
		return "liste";
	}
	
	@GetMapping({"", "/form"})
	public String afficherForm(Model model) {
		model.addAttribute("biere", new Biere());
		return "form";
	}
	
	@GetMapping("/del")
	public String supprBiere(Model model, @RequestParam Long id) {
		biereService.deleteBiere(id);
		return "redirect:/liste";
	}
	
    @PostMapping("/form")
    public RedirectView saveUser(@ModelAttribute("biere") Biere biere, @RequestParam("image") MultipartFile multipartFile) throws IOException {
    	biereService.ajouterBiere(biere);
    	
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        biere.setPhoto(fileName);
         
        Biere savedBiere = biereRepo.save(biere);
 
        String uploadDir = "bp/" + savedBiere.getId();
 
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
         
        return new RedirectView("/liste", true);
    }
	
}
