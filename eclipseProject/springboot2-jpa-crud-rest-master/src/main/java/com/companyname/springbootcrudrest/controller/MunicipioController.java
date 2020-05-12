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
import com.companyname.springbootcrudrest.model.Municipio;
import com.companyname.springbootcrudrest.repository.MunicipioRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class MunicipioController {
	
	@Autowired
	private MunicipioRepository municipioRepository;

	
	@GetMapping("/municipios")
	public List<Municipio> getAllMunicipios() {
		return municipioRepository.findAll();
	}

	@RequestMapping(value="/municipiosdeEstado/{id}")
	@ResponseBody
	public List<Municipio> method9(	@PathVariable(value = "id") long idEstado) throws ResourceNotFoundException {
		
		return municipioRepository.findByIdEstado(idEstado);
	}
	@GetMapping("/municipios/{id}")
	public ResponseEntity<Municipio> getMunicipioById(
			@PathVariable(value = "id") Long idMunicipio) throws ResourceNotFoundException {
		Municipio municipio = municipioRepository.findById(idMunicipio)
        .orElseThrow(() -> new ResourceNotFoundException("Municipio not found :: " + idMunicipio));
		return ResponseEntity.ok().body(municipio);
	}

	@PostMapping("/municipios")
	public Municipio createMunicipio(@Valid @RequestBody Municipio municipio) {
		return municipioRepository.save(municipio);
	}

	@PutMapping("/municipios/{id}")
	public ResponseEntity<Municipio> updateMunicipio(
			@PathVariable(value = "id") Long idMunicipio,
			@Valid @RequestBody Municipio municipioDetails) throws ResourceNotFoundException {
		Municipio municipio = municipioRepository.findById(idMunicipio)
		        .orElseThrow(() -> new ResourceNotFoundException("Municipio not found :: " + idMunicipio));
		
		municipio.setIdEstado(municipioDetails.getIdEstado());
		municipio.setCveMunicipio(municipioDetails.getCveMunicipio());
		municipio.setNombre(municipioDetails.getNombre());
		municipio.setLatitud(municipioDetails.getLatitud());
		municipio.setLongitud(municipioDetails.getLongitud());
		
		final Municipio updatedMunicipio = municipioRepository.save(municipio);
		return ResponseEntity.ok(updatedMunicipio);
	}

	@DeleteMapping("/municipios/{id}")
	public Map<String, Boolean> deleteMunicipio(
			@PathVariable(value = "id") Long idMunicipio) throws ResourceNotFoundException {
		Municipio municipio = municipioRepository.findById(idMunicipio)
		        .orElseThrow(() -> new ResourceNotFoundException("Municipio not found :: " + idMunicipio));

		municipioRepository.delete(municipio);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
