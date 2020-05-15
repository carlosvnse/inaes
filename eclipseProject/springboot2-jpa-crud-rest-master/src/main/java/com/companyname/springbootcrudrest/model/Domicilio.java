package com.companyname.springbootcrudrest.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "domicilios")
@EntityListeners(AuditingEntityListener.class)
public class Domicilio {

	private long idDomicilio;
	private long idEstado;
	private long idMunicipio;
	private long idLocalidad;
	private String tipoVialidad;
	private String domicilio;
	private String numInterior;
	private String numExterior;
	private BigDecimal latitud;
	private BigDecimal longitud;
	private String referencia;
	
	@Id
	@Column(name = "idDomicilio", nullable = false)
	public long getIdDomicilio() {
		return idDomicilio;
	}
	public void setIdDomicilio(long idDomicilio) {
		this.idDomicilio = idDomicilio;
	}
	
	@Column(name = "idEstado", nullable = false)
	public long getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(long idEstado) {
		this.idEstado = idEstado;
	}
	
	@Column(name = "idMunicipio", nullable = false)
	public long getIdMunicipio() {
		return idMunicipio;
	}
	public void setIdMunicipio(long idMunicipio) {
		this.idMunicipio = idMunicipio;
	}
	
	@Column(name = "idLocalidad", nullable = true)
	public long getIdLocalidad() {
		return idLocalidad;
	}
	public void setIdLocalidad(long idLocalidad) {
		this.idLocalidad = idLocalidad;
	}
	
	@Column(name = "tipoVialidad", nullable = true)
	public String getTipoVialidad() {
		return this.tipoVialidad;
	}
	public void setTipoVialidad(String tipoVialidad) {
		this.tipoVialidad = tipoVialidad;
	}
	
	@Column(name = "domicilio", nullable = false)
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	
	@Column(name = "numExterior", nullable = false)
	public String getNumExterior() {
		return numExterior;
	}
	public void setNumExterior(String numExterior) {
		this.numExterior = numExterior;
	}
	
	@Column(name = "numInterior", nullable = true)
	public String getNumInterior() {
		return numInterior;
	}
	public void setNumInterior(String numInterior) {
		this.numInterior = numInterior;
	}
	
	@Column(name = "referencia", nullable = true)
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	
	@Column(name = "latitud", nullable = true)
	public BigDecimal getLatitud() {
		return latitud;
	}
	public void setLatitud(BigDecimal latitud) {
		this.latitud = latitud;
	}
	
	@Column(name = "longitud", nullable = true)
	public BigDecimal getLongitud() {
		return longitud;
	}
	public void setLongitud(BigDecimal longitud) {
		this.longitud = longitud;
	}
}