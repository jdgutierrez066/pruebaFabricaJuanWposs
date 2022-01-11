package com.pruebaFabricaVideoJuegos.Model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="alquiler")

public class ModelAlquiler implements Serializable {


	private static final long serialVersionUID = 8641880011748891220L;

	@Id
	@Column(name="id_alquiler")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAlquiler;

	@ManyToOne
	@JoinColumn(name = "cliente", nullable = false, referencedColumnName = "id_cliente")
	@JsonBackReference
	private ModelCliente cliente;
	
	
	@ManyToMany
	@JoinTable(name="alquiler_juego",joinColumns = @JoinColumn(name="id_alquiler"),inverseJoinColumns = @JoinColumn(name="id_juego"))
	List<ModelJuego> listJuegos;
	
	private Date fec_inicio_alq; 	
	private Date fec_fin_alq;
	private Long precio_alq;
	
	
	public ModelAlquiler( ModelCliente cliente, List<ModelJuego> listJuegos, Date fec_inicio_alq,
			Date fec_fin_alq, Long precio_alq) {
		super();
		this.cliente = cliente;
		this.listJuegos = listJuegos;
		this.fec_inicio_alq = fec_inicio_alq;
		this.fec_fin_alq = fec_fin_alq;
		this.precio_alq = precio_alq;
	}


	public ModelAlquiler() {
		super();
	}


	public Integer getIdAlquiler() {
		return idAlquiler;
	}


	public void setIdAlquiler(Integer idAlquiler) {
		this.idAlquiler = idAlquiler;
	}


	public ModelCliente getCliente() {
		return cliente;
	}


	public void setCliente(ModelCliente cliente) {
		this.cliente = cliente;
	}


	public List<ModelJuego> getListJuegos() {
		return listJuegos;
	}


	public void setListJuegos(List<ModelJuego> listJuegos) {
		this.listJuegos = listJuegos;
	}


	public Date getFec_inicio_alq() {
		return fec_inicio_alq;
	}


	public void setFec_inicio_alq(Date fec_inicio_alq) {
		this.fec_inicio_alq = fec_inicio_alq;
	}


	public Date getFec_fin_alq() {
		return fec_fin_alq;
	}


	public void setFec_fin_alq(Date fec_fin_alq) {
		this.fec_fin_alq = fec_fin_alq;
	}


	public Long getPrecio_alq() {
		return precio_alq;
	}


	public void setPrecio_alq(Long precio_alq) {
		this.precio_alq = precio_alq;
	}
	
	
}
