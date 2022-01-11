package com.pruebaFabricaVideoJuegos.Dto;


public class DtoJuego {

	private Integer idJuego;
	
	private String tit_juego;
	private String nom_juego;
	private String year_juego;
	private String director_juego;
	private String productor_juego;
	private String tipTecnologia_juego;
	private Integer precio_juego;
	private boolean status_juego;
	
	public DtoJuego(Integer idJuego, String tit_juego, String nom_juego, String year_juego, String director_juego,
			String productor_juego, String tipTecnologia_juego, Integer precio_juego, boolean status_juego) {
		super();
		this.idJuego = idJuego;
		this.tit_juego = tit_juego;
		this.nom_juego = nom_juego;
		this.year_juego = year_juego;
		this.director_juego = director_juego;
		this.productor_juego = productor_juego;
		this.tipTecnologia_juego = tipTecnologia_juego;
		this.precio_juego = precio_juego;
		this.status_juego = status_juego;
	}

	public DtoJuego() {
		super();
	}

	public Integer getIdJuego() {
		return idJuego;
	}

	public void setIdJuego(Integer idJuego) {
		this.idJuego = idJuego;
	}

	public String getTit_juego() {
		return tit_juego;
	}

	public void setTit_juego(String tit_juego) {
		this.tit_juego = tit_juego;
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

	public String getTipTecnologia_juego() {
		return tipTecnologia_juego;
	}

	public void setTipTecnologia_juego(String tipTecnologia_juego) {
		this.tipTecnologia_juego = tipTecnologia_juego;
	}

	public Integer getPrecio_juego() {
		return precio_juego;
	}

	public void setPrecio_juego(Integer precio_juego) {
		this.precio_juego = precio_juego;
	}

	public boolean isStatus_juego() {
		return status_juego;
	}

	public void setStatus_juego(boolean status_juego) {
		this.status_juego = status_juego;
	}

	
	
	
	
	
	
}
