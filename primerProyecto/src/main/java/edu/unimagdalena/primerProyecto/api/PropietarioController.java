package edu.unimagdalena.primerProyecto.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import edu.unimagdalena.primerProyecto.model.Propietario;
import edu.unimagdalena.primerProyecto.repository.PropietarioRepository;

@RestController
@RequestMapping("/api")
//definimos la direccion o direcciones del controlador
@CrossOrigin(origins = "http://localhost:8080")
public class PropietarioController {

	@Autowired
	private PropietarioRepository propietarioRep;
	
	//	/api/propietarios
	@GetMapping("/propietarios")
	public ResponseEntity<List<Propietario>> getAllPropietarios() {
		List<Propietario> listaPropietarios = propietarioRep.findAll();
		if (listaPropietarios.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<>(listaPropietarios, HttpStatus.OK);
		}
	}
	
	@GetMapping("/propietarios/{id}")
	public ResponseEntity<Propietario> getPropietario(@PathVariable("id") Long id) {
		Optional<Propietario> propietario = propietarioRep.findById(id);
		if (propietario.isPresent()) {
			return new ResponseEntity<>(propietario.get(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/propietarios")
	public ResponseEntity<Propietario> createPropietario(@RequestBody Propietario p) {
		try {
			Propietario propietario = propietarioRep.save(p);
			return new ResponseEntity<>(propietario, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/propietarios/{id}")
	public ResponseEntity<Propietario> updatePropietario(@PathVariable("id") Long id, @RequestBody Propietario p) {
		Optional<Propietario> datosPropietario = propietarioRep.findById(id);
		if (datosPropietario.isPresent()) {
			Propietario propietario = datosPropietario.get();
			propietario.setNombre(p.getNombre());
			propietario.setIdentificacion(p.getIdentificacion());
			propietario.setMascotas(p.getMascotas());
			Propietario nuevoPropietario = propietarioRep.save(propietario);
			return new ResponseEntity<>(nuevoPropietario, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/propietarios/{id}")
	public ResponseEntity<HttpStatus> deletePropietario(@PathVariable("id") Long id) {
		try {
			propietarioRep.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
