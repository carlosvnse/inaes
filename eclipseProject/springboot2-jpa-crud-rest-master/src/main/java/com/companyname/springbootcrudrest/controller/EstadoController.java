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
import org.springframework.web.bind.annotation.RestController;

import com.companyname.springbootcrudrest.exception.ResourceNotFoundException;
import com.companyname.springbootcrudrest.model.Estado;
import com.companyname.springbootcrudrest.repository.EstadoRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class EstadoController {
	
	@Autowired
	private EstadoRepository estadoRepository;

	@CrossOrigin
	@GetMapping("/estados")
	public List<Estado> getAllEstados() {
		return estadoRepository.findAll();
	}

	@GetMapping("/estados/{id}")
	public ResponseEntity<Estado> getEstadoById(
			@PathVariable(value = "id") Long idEstado) throws ResourceNotFoundException {
		Estado estado = estadoRepository.findById(idEstado)
        .orElseThrow(() -> new ResourceNotFoundException("Estado not found :: " + idEstado));
		return ResponseEntity.ok().body(estado);
	}

	@PostMapping("/estados")
	public Estado createEstado(@Valid @RequestBody Estado estado) {
		return estadoRepository.save(estado);
	}

	@PutMapping("/estados/{id}")
	public ResponseEntity<Estado> updateEstado(
			@PathVariable(value = "id") Long idEstado,
			@Valid @RequestBody Estado estadoDetails) throws ResourceNotFoundException {
		Estado estado = estadoRepository.findById(idEstado)
		        .orElseThrow(() -> new ResourceNotFoundException("Estado not found :: " + idEstado));
		
		estado.setAbreviatura(estadoDetails.getAbreviatura() );
		estado.setCveEstado(estadoDetails.getCveEstado());
		estado.setNombre(estadoDetails.getNombre());
		estado.setLatitud(estadoDetails.getLatitud());
		estado.setLongitud(estadoDetails.getLongitud());
		
		final Estado updatedEstado = estadoRepository.save(estado);
		return ResponseEntity.ok(updatedEstado);
	}

	@DeleteMapping("/estados/{id}")
	public Map<String, Boolean> deleteEstado(
			@PathVariable(value = "id") Long idEstado) throws ResourceNotFoundException {
		Estado estado = estadoRepository.findById(idEstado)
		        .orElseThrow(() -> new ResourceNotFoundException("Estado not found :: " + idEstado));

		estadoRepository.delete(estado);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
