package servicios;

import modelos.Alumno;
import modelos.Materia;
import modelos.MateriaEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlumnoServicioTest {

    private AlumnoServicio alumnoServicio;
    private Materia matematicas;
    private Materia lenguaje;
    private Materia ciencias;
    private Materia historia;
    private Alumno mapu;

    @BeforeEach
    public void setup() {
        alumnoServicio = new AlumnoServicio();
        matematicas = new Materia(MateriaEnum.MATEMATICAS);
        lenguaje = new Materia(MateriaEnum.LENGUAJE);
        ciencias = new Materia(MateriaEnum.CIENCIAS);
        historia = new Materia(MateriaEnum.HISTORIA);
        mapu = new Alumno("99999999-8", "Hanamichi", "Sakuragi", "Alguna parte de Japon 13", 16);
    }

    @Test
    public void crearAlumnoTest() {
        alumnoServicio.crearAlumno(mapu);
        Map<String, Alumno> alumnos = alumnoServicio.listarAlumnos();
        assertEquals(1, alumnos.size());
        assertEquals(mapu, alumnos.get("99999999-8"));
    }

    @Test
    public void agregarMateriaTest() {
        alumnoServicio.crearAlumno(mapu);
        alumnoServicio.agregarMateria("99999999-8", matematicas);
        List<Materia> materias = alumnoServicio.materiasPorAlumno("99999999-8");
        assertEquals(1, materias.size());
        assertEquals(matematicas, materias.get(0));
    }

    @Test
    public void materiasPorAlumnosTest() {
        alumnoServicio.crearAlumno(mapu);
        alumnoServicio.agregarMateria("99999999-8", matematicas);
        alumnoServicio.agregarMateria("99999999-8", lenguaje);
        alumnoServicio.agregarMateria("99999999-8", ciencias);
        alumnoServicio.agregarMateria("99999999-8", historia);

        List<Materia> materias = alumnoServicio.materiasPorAlumno("99999999-8");
        assertEquals(4, materias.size()); // Cambiado el valor esperado a 4
        assertEquals(matematicas, materias.get(0));
        assertEquals(lenguaje, materias.get(1));
        assertEquals(ciencias, materias.get(2));
        assertEquals(historia, materias.get(3));
    }

    @Test
    public void listarAlumnosTest() {
        alumnoServicio.crearAlumno(mapu);
        Map<String, Alumno> alumnos = alumnoServicio.listarAlumnos();
        assertEquals(1, alumnos.size());
        assertEquals(mapu, alumnos.get("99999999-8"));
    }
}









