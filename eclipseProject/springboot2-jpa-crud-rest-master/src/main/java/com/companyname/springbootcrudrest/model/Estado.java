package com.companyname.springbootcrudrest.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "cat_estados")
@EntityListeners(AuditingEntityListener.class)
public class Estado {

	private long idEstado;
	private String cveEstado;
	private String nombre;
	private String abreviatura;
	private BigDecimal latitud;
	private BigDecimal longitud;
	
	@Id
	@Column(name = "idEstado", nullable = false)
	public long getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(long idEstado) {
		this.idEstado = idEstado;
	}
	
	@Column(name = "cveEstado", nullable = false)
	public String getCveEstado() {
		return cveEstado;
	}
	public void setCveEstado(String cveEstado) {
		this.cveEstado = cveEstado;
	}
	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Column(name = "abreviatura", nullable = false)
	public String getAbreviatura() {
		return abreviatura;
	}
	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
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
	
	
}
