package com.example.CavaBiere.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.CavaBiere.bo.Biere;
import com.example.CavaBiere.bo.Type;
import com.example.CavaBiere.dal.BiereRepository;
import com.example.CavaBiere.dal.TypeRepository;

@Service
public class BiereServiceImpl implements BiereService {

	//Lien avec couche DAL
	@Autowired
	private BiereRepository biereRepo;
	private TypeRepository typeRepo;

	public BiereServiceImpl(BiereRepository biereRepo, TypeRepository typeRepo) {
		this.biereRepo = biereRepo;
		this.typeRepo = typeRepo;
	}
	
	@Override
	public List<Biere> getBieres() {
		return biereRepo.findAll();
	}

	@Override
	public void ajouterBiere(Biere biere) {
		biereRepo.save(biere);
	}
	
	@Override
	public void deleteBiere(Long id) {
		biereRepo.deleteById(id);
	}

	//Ajout du type de bière
	@Override
	public List<Type> getTypes() {
		return typeRepo.findAll();
	}
	
}
