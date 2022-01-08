package com.pruebaFabricaVideoJuegos.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="tipo_tecnologia")

public class ModelTipoTecnologia implements Serializable  {


	private static final long serialVersionUID = 5035717571597406649L;
	
	@Id
	@Column(name="id_tipo_tecnologia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTipo_Tenologia;
	
	@OneToMany(mappedBy = "tipo_tecnologia",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<ModelJuego> listJuegos;
	
	


	private String nomTipo_tecnologia;

	public String getNomTipo_tecnologia() {
		return nomTipo_tecnologia;
	}

	public void setNomTipo_tecnologia(String nomTipo_tecnologia) {
		this.nomTipo_tecnologia = nomTipo_tecnologia;
	}
	
	public List<ModelJuego> getListJuegos() {
		return listJuegos;
	}

	public void setListJuegos(List<ModelJuego> listJuegos) {
		this.listJuegos = listJuegos;
	}
	
}
