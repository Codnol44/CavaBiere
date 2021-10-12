package com.example.CavaBiere.bo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.util.StringUtils;

@Entity
public class Biere implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	private String nom;
	private String pays;
	private int degre;
	private String description;
	
	@Column(nullable = true, length = 64)
	private String photo;
	
	@ManyToOne
	private Type type;
	
	public Biere() {
		super();}
	
	public Biere(String nom, String pays, int degre, String description, Type type, String photo) {
		super();
		this.nom = nom;
		this.pays = pays;
		this.degre = degre;
		this.description = description;
		this.type = type;
		this.photo = photo;
	}
	
	public Biere(Long id, String nom, String pays, int degre, String description, Type type, String photo) {
		super();
		this.id = id;
		this.nom = nom;
		this.pays = pays;
		this.degre = degre;
		this.description = description;
		this.type = type;
		this.photo = photo;
	}

	@Transient
	public String getPhotosImagePath() {
	    return "/bp/" + id + "/" + photo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getDegre() {
		return degre;
	}

	public void setDegre(int degre) {
		this.degre = degre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Biere [id=" + id + ", nom=" + nom + ", pays=" + pays + ", type=" + type +", degre=" + degre
				+ ", description=" + description + "]";
	}

}
