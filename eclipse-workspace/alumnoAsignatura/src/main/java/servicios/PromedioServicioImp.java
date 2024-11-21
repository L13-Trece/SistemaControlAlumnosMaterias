package servicios;

import modelos.Alumno;
import modelos.Materia;

public class PromedioServicioImp {
    
    public double calcularPromedio(Alumno alumno) {
        double suma = 0;
        int totalNotas = 0;

        for (Materia materia : alumno.getMaterias()) {
            for (Double nota : materia.getNotas()) {
                suma += nota;
                totalNotas++;
            }
        }

        return totalNotas > 0 ? suma / totalNotas : 0;
    }
}



