package proyectoGimnasia.vistas;

public class ParticipantesView {
	/**
	 * Menú Participantes:
	 * 1- Mostrar participantes
	 * 2- Menú gimnastas
	 * 3- Menú grupos
	 * 4- Salir
	 */
	
	public static void menuParticipantes() {
		print(" ---------- Menú Participantes      ---------- ");
		print("|                                             |");
		print("|                                             |");
		print("|  {1} Mostrar participantes                  |");
		print("|  {2} Menú gimnastas                         |");
		print("|  {3} Menú grupos                            |");
		print("|  {4} Salir                                  |");
		print("|                                             |");
		print(" --------------------------------------------- ");
		
	}
	
	/**
	 * Método para mostrar por pantalla.
	 */
	public static void print (String text) {
		System.out.println(text);
	}
}
