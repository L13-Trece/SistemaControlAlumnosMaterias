package vistas;

import modelos.Alumno;
import modelos.Materia;
import modelos.MateriaEnum;
import servicios.AlumnoServicio;
import servicios.ArchivoServicio;

import java.io.IOException;
import java.util.Scanner;
import java.util.Map;


public class Menu extends MenuTemplate {
	
		private AlumnoServicio alumnoServicio = new AlumnoServicio ();
		
		private ArchivoServicio archivoServicio = new ArchivoServicio ();
		private Scanner scanner = new Scanner(System.in);
	
		
	@Override 
	
	public void iniciarMenu() {
		
		Scanner scanner = new Scanner(System.in);
		boolean salir = false;
		
		while (!salir) {
			
			iniciarMenu();
			
			System.out.print("Selecciona una opcion: ");
			int opcion = scanner.nextInt();
			scanner.nextLine();
			
			switch (opcion) {
			
			case 1:
				exportarDatosJson();
			break;
				
			case 2: 
				exportarDatosCsv();
			break;
			
			case 3: 
				crearAlumno();
			break;
			
			case 4: 
				agregarMateria();
			break;
			
			case 5:
				listarAlumnos();
			break;
			
			case 6: 
				salir = true;
				System.out.println("Saliendo del menu...");
			break;
			
			default:
				System.out.println("Opcion no valida, intentalo de nuevo...");
			
			}
		}
		
		scanner.close();
	}
	
	

 
    public void crearAlumno (Scanner scanner) {
	   
	System.out.println ("Ingresa nombre del alumno: ");
	String nombre = scanner.nextLine();
	
	System.out.print("Ingresa el apellido del alumno: ");
	String apellido = scanner.nextLine();
	
	System.out.print("Ingresa el Rut del alumno: ");
	String rut = scanner.nextLine();
	
	System.out.print("Ingresa la direccion del alumno: ");
	String direccion = scanner.nextLine();
	
	System.out.print("Ingresa la edad del alumno: ");
	int edad = scanner.nextInt();
	
	
	
	
	scanner.nextLine();
	
	Alumno alumno = new Alumno (nombre, apellido, rut, direccion, edad);
	alumnoServicio.crearAlumno(alumno);
	System.out.println("Alumno creado exitosamente.");
    }

   
  
   protected void agregarMateria () {
	System.out.println ("Ingresa el Rut del alumno: ");
	String rutAlumno = scanner.nextLine();
	
	System.out.print ("Ingresa el nombre de la materia (MATEMATICAS,LENGUAJE, CIENCIAS, HISTORIA: ");
	String nombreMateriaStr = scanner.nextLine();
	
	MateriaEnum nombreMateria = MateriaEnum.valueOf(nombreMateriaStr.toUpperCase());
	Materia materia = new Materia (nombreMateria);
	
	System.out.print("Ingresa la nota de la materia: ");
	double nota = scanner.nextDouble();
	
	scanner.nextLine();
	materia.addNota (nota);
	
	alumnoServicio.agregarMateria(rutAlumno,  materia);
	System.out.println("Materia agregada exitosamente.");
	
    }


 
   protected void listarAlumnos () {
	   Map<String, Alumno> alumnos = alumnoServicio.listarAlumnos();
	   
	   if (alumnos.isEmpty()) {
		   System.out.println ("No hay alumnos registrados.");
		   
	   } else {
	       System.out.println ("Lista de alumnos: ");
	       
	     for (Alumno alumno : alumnos.values()) {
		   System.out.println ("Rut: " + alumno.getRut() + " , Nombre: " + alumno.getNombre() + ", Apellido: " + alumno.getApellido() + ", Direccion: " + 
				   alumno.getDireccion() + ", Edad: " + alumno.getEdad());
	}
    }
    }
   
   

   public void exportarDatosJson() {
	   try {
		   archivoServicio.exportarDatosJson(alumnoServicio.listarAlumnos(), "datos.json");
		   System.out.println ("Datos exportados a Json exitosamente.");
	   } catch (IOException e) {
		   System.out.println ("Error al exportar los datos a Json: " + e.getMessage());
	   }
   }
   
   public void exportarDatosCsv () {
	   try {
		   archivoServicio.exportarDatosCsv (alumnoServicio.listarAlumnos(), "datos.csv");
		   System.out.println ("Datos exportados a Csv exitosamente.");
	   } catch (IOException e) {
		   System.out.println ("Error al exportar los datos a Csv: " + e.getMessage());
	   }
   }


@Override
protected void exportarDatos() {
	// TODO Auto-generated method stub
	
}


@Override
protected void crearAlumno() {
	// TODO Auto-generated method stub
	
}


@Override
protected void agregarNotaPasoUno() {
	// TODO Auto-generated method stub
	
}


@Override
protected void terminarPrograma() {
	// TODO Auto-generated method stub
	
}

}


	   



