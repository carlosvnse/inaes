package com.companyname.springbootcrudrest.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "cat_municipios")
@EntityListeners(AuditingEntityListener.class)
public class Municipio {

	private long idMunicipio;
	private long idEstado;
	private String cveMunicipio;
	private String nombre;
	private BigDecimal latitud;
	private BigDecimal longitud;
	
	
	@Id
	@Column(name = "idMunicipio", nullable = false)
	public long getIdMunicipio() {
		return idMunicipio;
	}
	public void setIdMunicipio(long idMunicipio) {
		this.idMunicipio = idMunicipio;
	}
	
	@Column(name = "idEstado", nullable = false)
	public long getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(long idEstado) {
		this.idEstado = idEstado;
	}
	
	@Column(name = "cveMunicipio", nullable = false)
	public String getCveMunicipio() {
		return cveMunicipio;
	}
	public void setCveMunicipio(String cveMunicipio) {
		this.cveMunicipio = cveMunicipio;
	}
	
	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
