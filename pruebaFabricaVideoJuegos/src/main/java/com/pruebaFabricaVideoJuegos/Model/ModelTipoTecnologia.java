package com.pruebaFabricaVideoJuegos.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_tecnologia")

public class ModelTipoTecnologia implements Serializable  {


	private static final long serialVersionUID = 5035717571597406649L;
	
	@Id
	@Column(name="id_tipo_Tenologia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTipo_Tenologia;

	private String nomTipo_tecnologia;

	public String getNomTipo_tecnologia() {
		return nomTipo_tecnologia;
	}

	public void setNomTipo_tecnologia(String nomTipo_tecnologia) {
		this.nomTipo_tecnologia = nomTipo_tecnologia;
	}
	
}
