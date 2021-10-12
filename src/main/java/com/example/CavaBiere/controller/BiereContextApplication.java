package com.example.CavaBiere.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.CavaBiere.bo.Type;
import com.example.CavaBiere.service.BiereService;

public class BiereContextApplication {

	private BiereService biereService;
	private List<Type> types;

	
	@Autowired
	public BiereContextApplication(BiereService biereService) {
		this.biereService = biereService;
	}
	
	public List<Type> getTypes() {
		if(this.types == null) {
			types = biereService.getTypes();
		}
		return types;
	}
	
}
