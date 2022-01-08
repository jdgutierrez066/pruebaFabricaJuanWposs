package com.pruebaFabricaVideoJuegos.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name ="cliente")

public class ModelCliente implements Serializable{

	private static final long serialVersionUID = -8260444941217573373L;

	
	@Id
	@Column(name ="id_cliente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<ModelAlquiler> listAlquilados;
	
	
	private Integer cc_cli;
	private String nom_cli;
	private String ape_cli;
	private Integer cel_cli;

	
	public Integer getIdcliente() {
		return idCliente;
	}
	public void setIdcliente(Integer idcliente) {
		this.idCliente = idcliente;
	}
	public Integer getNo_cc_cliente() {
		return cc_cli;
	}
	public void setNo_cc_cliente(Integer no_cc_cliente) {
		this.cc_cli = no_cc_cliente;
	}
	public String getNom_cliente() {
		return nom_cli;
	}
	public void setNom_cliente(String nom_cliente) {
		this.nom_cli = nom_cliente;
	}
	public String getApe_cliente() {
		return ape_cli;
	}
	public void setApe_cliente(String ape_cliente) {
		this.ape_cli = ape_cliente;
	}
	public Integer getNo_cel_cliente() {
		return cel_cli;
	}
	public void setNo_cel_cliente(Integer no_cel_cliente) {
		this.cel_cli = no_cel_cliente;
	}
	public List<ModelAlquiler> getListAlquilados() {
		return listAlquilados;
	}
	public void setListAlquilados(List<ModelAlquiler> listAlquilados) {
		this.listAlquilados = listAlquilados;
	}
	
	
	
	
	
}
