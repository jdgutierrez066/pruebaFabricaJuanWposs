package com.pruebaFabricaVideoJuegos.Dto;

public class DtoCliente {
	
	private Integer id_cli;
	private Integer cc_cli;
	private String nom_cli;
	private String ape_cli;
	private Integer cel_cli;
	
	public DtoCliente(Integer id_cli, Integer cc_cli, String nom_cli, String ape_cli, Integer cel_cli) {
		super();
		this.id_cli = id_cli;
		this.cc_cli = cc_cli;
		this.nom_cli = nom_cli;
		this.ape_cli = ape_cli;
		this.cel_cli = cel_cli;
	}

	public DtoCliente() {
		super();
	}

	public Integer getId_cli() {
		return id_cli;
	}

	public void setId_cli(Integer id_cli) {
		this.id_cli = id_cli;
	}

	public Integer getCc_cli() {
		return cc_cli;
	}

	public void setCc_cli(Integer cc_cli) {
		this.cc_cli = cc_cli;
	}

	public String getNom_cli() {
		return nom_cli;
	}

	public void setNom_cli(String nom_cli) {
		this.nom_cli = nom_cli;
	}

	public String getApe_cli() {
		return ape_cli;
	}

	public void setApe_cli(String ape_cli) {
		this.ape_cli = ape_cli;
	}

	public Integer getCel_cli() {
		return cel_cli;
	}

	public void setCel_cli(Integer cel_cli) {
		this.cel_cli = cel_cli;
	}
	
	
}
