package com.example.CavaBiere.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Type {

	@Id
	@GeneratedValue
	private Long no;
	private String nom;
	
	public Type(Long no, String nom) {
		super();
		this.no = no;
		this.nom = nom;
	}
	
	public Type() {
		super();
	}
	
	public Type(String nom) {
		super();
		this.nom = nom;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Type [no=" + no + ", nom=" + nom + "]";
	}
	
}
