package servicios;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import modelos.Alumno;
import modelos.Materia;
import modelos.MateriaEnum;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class PromedioServicioImpTest {

    private PromedioServicioImp promedioServicioImp;
    private Alumno alumno;

    @BeforeEach
    public void setUp() {
        promedioServicioImp = new PromedioServicioImp();
        alumno = new Alumno("98765432-1", "Bart", "Simpson", "Calle Siempre Viva s/n", 10);
        List<Materia> materias = new ArrayList<>();

        Materia matematicas = new Materia(MateriaEnum.MATEMATICAS);
        matematicas.addNota(3.5);
        materias.add(matematicas);

        Materia lenguaje = new Materia(MateriaEnum.LENGUAJE);
        lenguaje.addNota(7.0);
        materias.add(lenguaje);

        Materia ciencias = new Materia(MateriaEnum.CIENCIAS);
        ciencias.addNota(4.5);
        materias.add(ciencias);

        Materia historia = new Materia(MateriaEnum.HISTORIA);
        historia.addNota(5.0);
        materias.add(historia);

        alumno.setMaterias(materias);
    }

    @Test
    public void testCalcularPromedio() {
        double promedio = promedioServicioImp.calcularPromedio(alumno);
        assertEquals(5.0, promedio, 0.01);  // Ajusta el valor esperado según los datos de prueba.
    }

    @Test
    public void testCalcularPromedioSinMaterias() {
        Alumno alumnoSinMaterias = new Alumno("77777777-7", "Robert", "Smith", "London Bridge 13", 13);
        double promedio = promedioServicioImp.calcularPromedio(alumnoSinMaterias);
        assertEquals(0.0, promedio, 0.01);
    }
}




