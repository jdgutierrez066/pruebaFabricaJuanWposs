package com.pruebaFabricaVideoJuegos.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="juego")

public class ModelJuego implements Serializable {

	
	private static final long serialVersionUID = -3055130392984654050L;
	

	@Id
	@Column(name="id_juego")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idJuego;
	
	private String nom_juego;
	private String year_juego;
	private String director_juego;
	private String productor_juego;
	private String precio_juego;
	
	public Integer getIdJuego() {
		return idJuego;
	}
	public void setIdJuego(Integer idJuego) {
		this.idJuego = idJuego;
	}
	public String getNom_juego() {
		return nom_juego;
	}
	public void setNom_juego(String nom_juego) {
		this.nom_juego = nom_juego;
	}
	public String getYear_juego() {
		return year_juego;
	}
	public void setYear_juego(String year_juego) {
		this.year_juego = year_juego;
	}
	public String getDirector_juego() {
		return director_juego;
	}
	public void setDirector_juego(String director_juego) {
		this.director_juego = director_juego;
	}
	public String getProductor_juego() {
		return productor_juego;
	}
	public void setProductor_juego(String productor_juego) {
		this.productor_juego = productor_juego;
	}
	public String getPrecio_juego() {
		return precio_juego;
	}
	public void setPrecio_juego(String precio_juego) {
		this.precio_juego = precio_juego;
	}	
	
	
}
