package com.companyname.springbootcrudrest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.companyname.springbootcrudrest.exception.ResourceNotFoundException;
import com.companyname.springbootcrudrest.model.Domicilio;
import com.companyname.springbootcrudrest.repository.DomicilioRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class DomicilioController {
	
	@Autowired
	private DomicilioRepository domicilioRepository;

	
	@GetMapping("/domicilios")
	public List<Domicilio> getAllDomicilioes() {
		return domicilioRepository.findAll();
	}
	
	@RequestMapping(value="/domiciliosdeMunicipio/{id}")
	@ResponseBody
	public List<Domicilio> method9(	@PathVariable(value = "id") long idMunicipio) throws ResourceNotFoundException {
		
		return domicilioRepository.findByIdMunicipio(idMunicipio);
	}

	@GetMapping("/domicilios/{id}")
	public ResponseEntity<Domicilio> getDomicilioById(
			@PathVariable(value = "id") Long idDomicilio) throws ResourceNotFoundException {
		Domicilio domicilio = domicilioRepository.findById(idDomicilio)
        .orElseThrow(() -> new ResourceNotFoundException("Domicilio not found :: " + idDomicilio));
		return ResponseEntity.ok().body(domicilio);
	}

	@PostMapping("/domicilios")
	public Domicilio createDomicilio(@Valid @RequestBody Domicilio domicilio) {
		return domicilioRepository.save(domicilio);
	}

	@PutMapping("/domicilios/{id}")
	public ResponseEntity<Domicilio> updateDomicilio(
			@PathVariable(value = "id") Long idDomicilio,
			@Valid @RequestBody Domicilio domicilioDetails) throws ResourceNotFoundException {
		Domicilio domicilio = domicilioRepository.findById(idDomicilio)
		        .orElseThrow(() -> new ResourceNotFoundException("Domicilio not found :: " + idDomicilio));
		
		domicilio.setIdEstado(domicilioDetails.getIdMunicipio());
		domicilio.setIdMunicipio(domicilioDetails.getIdMunicipio());
		domicilio.setIdLocalidad(domicilioDetails.getIdLocalidad());
		domicilio.setTipoVialidad(domicilioDetails.getTipoVialidad());
		domicilio.setDomicilio(domicilioDetails.getDomicilio());
		domicilio.setNumInterior(domicilioDetails.getNumInterior());
		domicilio.setNumExterior(domicilioDetails.getNumExterior());
		domicilio.setLatitud(domicilioDetails.getLatitud());
		domicilio.setLongitud(domicilioDetails.getLongitud());
		domicilio.setReferencia(domicilioDetails.getReferencia());
		
		final Domicilio updatedDomicilio = domicilioRepository.save(domicilio);
		return ResponseEntity.ok(updatedDomicilio);
	}

	@DeleteMapping("/domicilios/{id}")
	public Map<String, Boolean> deleteDomicilio(
			@PathVariable(value = "id") Long idDomicilio) throws ResourceNotFoundException {
		Domicilio domicilio = domicilioRepository.findById(idDomicilio)
		        .orElseThrow(() -> new ResourceNotFoundException("Domicilio not found :: " + idDomicilio));

		domicilioRepository.delete(domicilio);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
}
