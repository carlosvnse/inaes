package com.companyname.springbootcrudrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.companyname.springbootcrudrest.model.Domicilio;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio, Long>{
	List<Domicilio> findByIdDomicilio(long idDomicilio);
	List<Domicilio> findByIdEstado(long idEstado);
	List<Domicilio> findByIdMunicipio(long idMunicipio);
	List<Domicilio> findByIdLocalidad(long idLocalidad);
}
