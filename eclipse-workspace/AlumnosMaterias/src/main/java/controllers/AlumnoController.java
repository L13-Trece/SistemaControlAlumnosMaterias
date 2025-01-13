package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Alumno;
import service.AlumnoService;

@RestController
@RequestMapping("/alumnos")

public class AlumnoController {
	@Autowired
	
	private AlumnoService alumnoServicios;
	
	@GetMapping
	
	public List<Alumno> findAll() {
		return alumnoServicios.findAll();
	}

	@PostMapping
	
	public Alumno save(@RequestBody Alumno alumno) {
		return alumnoServicios.save(alumno);
	}
}
