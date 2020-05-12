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
import com.companyname.springbootcrudrest.model.Localidad;
import com.companyname.springbootcrudrest.repository.LocalidadRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class LocalidadController {
	
	@Autowired
	private LocalidadRepository localidadRepository;

	
	@GetMapping("/localidades")
	public List<Localidad> getAllLocalidades() {
		return localidadRepository.findAll();
	}
	
	@RequestMapping(value="/localidadesdeMunicipio/{id}")
	@ResponseBody
	public List<Localidad> method9(	@PathVariable(value = "id") long idMunicipio) throws ResourceNotFoundException {
		
		return localidadRepository.findByIdMunicipio(idMunicipio);
	}

	@GetMapping("/localidades/{id}")
	public ResponseEntity<Localidad> getLocalidadById(
			@PathVariable(value = "id") Long idLocalidad) throws ResourceNotFoundException {
		Localidad localidad = localidadRepository.findById(idLocalidad)
        .orElseThrow(() -> new ResourceNotFoundException("Localidad not found :: " + idLocalidad));
		return ResponseEntity.ok().body(localidad);
	}

	@PostMapping("/localidades")
	public Localidad createLocalidad(@Valid @RequestBody Localidad localidad) {
		return localidadRepository.save(localidad);
	}

	@PutMapping("/localidades/{id}")
	public ResponseEntity<Localidad> updateLocalidad(
			@PathVariable(value = "id") Long idLocalidad,
			@Valid @RequestBody Localidad localidadDetails) throws ResourceNotFoundException {
		Localidad localidad = localidadRepository.findById(idLocalidad)
		        .orElseThrow(() -> new ResourceNotFoundException("Localidad not found :: " + idLocalidad));
		
		localidad.setIdMunicipio(localidadDetails.getIdMunicipio());
		localidad.setCveLocalidad(localidadDetails.getCveLocalidad());
		localidad.setNombre(localidadDetails.getNombre());
		localidad.setLatitud(localidadDetails.getLatitud());
		localidad.setLongitud(localidadDetails.getLongitud());
		localidad.setActivo(localidadDetails.getActivo());
		localidad.setMapa(localidadDetails.getMapa());
		localidad.setAmbito(localidadDetails.getAmbito());
		
		final Localidad updatedLocalidad = localidadRepository.save(localidad);
		return ResponseEntity.ok(updatedLocalidad);
	}

	@DeleteMapping("/localidades/{id}")
	public Map<String, Boolean> deleteLocalidad(
			@PathVariable(value = "id") Long idLocalidad) throws ResourceNotFoundException {
		Localidad localidad = localidadRepository.findById(idLocalidad)
		        .orElseThrow(() -> new ResourceNotFoundException("Localidad not found :: " + idLocalidad));

		localidadRepository.delete(localidad);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
}
