package com.example.CavaBiere.service;

import java.util.List;
import com.example.CavaBiere.bo.Biere;
import com.example.CavaBiere.bo.Type;

public interface BiereService {
	
	void ajouterBiere(Biere biere);
	
	public List<Biere> getBieres();
	
	void deleteBiere(Long id);
	
	public List<Type> getTypes();

}
