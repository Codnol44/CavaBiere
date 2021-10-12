package com.example.CavaBiere;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.CavaBiere.bo.Type;
import com.example.CavaBiere.controller.BiereContextApplication;
import com.example.CavaBiere.dal.TypeRepository;
import com.example.CavaBiere.service.BiereService;

@SpringBootApplication
public class CavaBiereApplication {

	public static void main(String[] args) {
		SpringApplication.run(CavaBiereApplication.class, args);
	}
	
	@Bean
	public BiereContextApplication biereContextApplication(BiereService biereService) {
		return new BiereContextApplication(biereService);
	}

	@Bean
	public CommandLineRunner initType(TypeRepository typeRepo) {
		return (args) -> {
			typeRepo.save(new Type("Blonde"));
			typeRepo.save(new Type("Blanche"));
			typeRepo.save(new Type("Brune"));
			typeRepo.save(new Type("Ambree"));
			typeRepo.save(new Type("Rousse"));
			typeRepo.save(new Type("IPA"));
		};
	}

}
