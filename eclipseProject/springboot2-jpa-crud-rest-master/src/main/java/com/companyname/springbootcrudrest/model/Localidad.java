package com.companyname.springbootcrudrest.model;

import java.math.BigDecimal;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "cat_localidades")
@EntityListeners(AuditingEntityListener.class)
public class Localidad {

	private long idLocalidad;
	private long idMunicipio;
	private String cveLocalidad;
	private String nombre;
	private BigDecimal latitud;
	private BigDecimal longitud;
	private Character ambito;
	private String mapa;
	private Boolean activo;
	
	
	
	@Id
	@Column(name = "idLocalidad", nullable = false)
	public long getIdLocalidad() {
		return idLocalidad;
	}
	public void setIdLocalidad(long idLocalidad) {
		this.idLocalidad = idLocalidad;
	}
	
	@Column(name = "idMunicipio", nullable = false)
	public long getIdMunicipio() {
		return idMunicipio;
	}
	public void setIdMunicipio(long idMunicipio) {
		this.idMunicipio = idMunicipio;
	}
	
	@Column(name = "cveLocalidad", nullable = false)
	public String getCveLocalidad() {
		return cveLocalidad;
	}
	public void setCveLocalidad(String cveLocalidad) {
		this.cveLocalidad = cveLocalidad;
	}
	
	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Column(name = "latitud", nullable = false)
	public BigDecimal getLatitud() {
		return latitud;
	}
	public void setLatitud(BigDecimal latitud) {
		this.latitud = latitud;
	}
	
	@Column(name = "longitud", nullable = false)
	public BigDecimal getLongitud() {
		return longitud;
	}
	public void setLongitud(BigDecimal longitud) {
		this.longitud = longitud;
	}
	
	@Column(name = "ambito", nullable = false)
	public Character getAmbito() {
		return ambito;
	}
	public void setAmbito(Character ambito) {
		this.ambito = ambito;
	}
	
	@Column(name = "mapa", nullable = false)
	public String getMapa() {
		return mapa;
	}
	public void setMapa(String mapa) {
		this.mapa = mapa;
	}
	@Column(name = "activo")
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
	
	
	
}
