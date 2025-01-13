package models;

import java.util.Set;

import org.springframework.data.annotation.Id;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.OneToMany;

@Entity

public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String rut;
	private String nombre;
	private String direccion;
	
	@OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL)
	
	private Set<Materia> materiaList;

}
