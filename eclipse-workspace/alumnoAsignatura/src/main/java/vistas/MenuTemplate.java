package vistas;

import java.util.Scanner;

public abstract class MenuTemplate {
	protected Scanner scanner;
	
	// Metodos abstractos
	

	protected abstract void exportarDatos ();
	
	protected abstract void crearAlumno ();
	
	protected abstract void agregarMateria ();
	
	protected abstract void agregarNotaPasoUno ();
	
	protected abstract void listarAlumnos ();
	
	protected abstract void terminarPrograma ();
	
	//Metodo final
	
	public void iniciarMenu () {
		int opcion;
		do {
			System.out.println (" Menu Principal: ");
			System.out.println (" 1. Exportar Datos ");
			System.out.println (" 2. Crear Alumno ");
			System.out.println (" 3. Agregar Materia ");
			System.out.println (" 4. Agregar Nota ");
			System.out.println (" 5. Listar Alumnos ");
			System.out.println (" 6. Terminar Programa ");
			System.out.println (" Seleccione una opcion: ");
			
			opcion = scanner.nextInt ();
			
			switch (opcion) {
			
			case 1:
				exportarDatos ();
				break;
			case 2:
				crearAlumno();
				break;
			case 3:
				agregarMateria ();
				break;
			case 4:
				agregarNotaPasoUno ();
				break;
			case 5:
				listarAlumnos ();
				break;
			case 6:
				terminarPrograma ();
				break;
			default:
				System.out.println ("Opcion no valida. Intentelo de nuevo.");
				
			}
			
		} while (opcion !=6);
	}
}

