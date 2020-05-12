package com.companyname.springbootcrudrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.companyname.springbootcrudrest.model.Localidad;

@Repository
public interface LocalidadRepository extends JpaRepository<Localidad, Long>{
	List<Localidad> findByIdMunicipio(long idMunicipio);
}
