package com.companyname.springbootcrudrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.companyname.springbootcrudrest.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{

}
