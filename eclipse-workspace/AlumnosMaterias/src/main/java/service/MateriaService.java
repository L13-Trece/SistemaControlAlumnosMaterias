package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Materia;
import repository.MateriaRepository;

@Service

public class MateriaService {
	
	@Autowired
	
	private MateriaRepository materiaRepository;
	
	public Materia save(Materia materia) {
		return materiaRepository.save(materia);
	}
	

}
