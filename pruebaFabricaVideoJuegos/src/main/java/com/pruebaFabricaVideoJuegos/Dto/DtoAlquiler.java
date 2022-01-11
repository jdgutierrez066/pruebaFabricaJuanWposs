package com.pruebaFabricaVideoJuegos.Dto;

import java.sql.Date;
import java.util.List;

import com.pruebaFabricaVideoJuegos.Model.ModelCliente;
import com.pruebaFabricaVideoJuegos.Model.ModelJuego;

public class DtoAlquiler {
	
	private Integer idAlquiler;
	private Integer idCliente;
	
	private List<ModelJuego> listJuegos;
	
	private Date fec_inicio_alq; 	
	private Date fec_fin_alq;
	private Long precio_alq;


	public DtoAlquiler( Integer idCliente, List<ModelJuego> listJuegos, Date fec_inicio_alq,
			Date fec_fin_alq, Long precio_alq) {
		super();
		this.idCliente = idCliente;
		this.listJuegos = listJuegos;
		this.fec_inicio_alq = fec_inicio_alq;
		this.fec_fin_alq = fec_fin_alq;
		this.precio_alq = precio_alq;
	}

	public DtoAlquiler(Integer idAlquiler) {
		super();
		this.idAlquiler = idAlquiler;
	}

	public DtoAlquiler() {
		super();
	}

	public Integer getIdAlquiler() {
		return idAlquiler;
	}

	public void setIdAlquiler(Integer idAlquiler) {
		this.idAlquiler = idAlquiler;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
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
