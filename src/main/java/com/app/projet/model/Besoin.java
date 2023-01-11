package com.app.projet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="besoins")
public class Besoin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_besoin")
	private long id;
	
	@Column(name="nbre_plats")
	private int nbrePlats ;
	
	@Column(name = "date_besoin")
	private String dateBesoin;
	
	@Column(name = "type_plat")
	private String typePlat;
	
	@ManyToOne(fetch = FetchType.LAZY)
	public Association association;
	
	public Association getAssociation() {
		return association;
	}

	public void setAssociation(Association association) {
		this.association = association;
	}

	public String getTypePlat() {
		return typePlat;
	}

	public void setTypePlat(String typePlat) {
		this.typePlat = typePlat;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNbrePlats() {
		return nbrePlats;
	}

	public void setNbrePlats(int nbrePlats) {
		this.nbrePlats = nbrePlats;
	}

	public String getDateBesoin() {
		return dateBesoin;
	}

	public void setDateBesoin(String dateBesoin) {
		this.dateBesoin = dateBesoin;
	}

}

