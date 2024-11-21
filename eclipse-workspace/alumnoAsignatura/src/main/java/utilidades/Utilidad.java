package utilidades;

public class Utilidad {
	public static void limpiarPantalla () {
		
		System.out.print("\033[H\033[2J");
		System.out.flush ();
	}
	
	public static void mostrarMensaje (String mensaje) {
		System.out.println (mensaje);
	}

}
