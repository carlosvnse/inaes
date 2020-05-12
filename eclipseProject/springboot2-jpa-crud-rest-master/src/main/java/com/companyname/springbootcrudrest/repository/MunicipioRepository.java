package com.companyname.springbootcrudrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.companyname.springbootcrudrest.model.Municipio;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Long>{
	List<Municipio> findByIdEstado(long idEstado);

}
