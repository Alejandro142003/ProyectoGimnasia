package proyectoGimnasia.vistas;

import proyectoGimnasia.utils.Utils;

public class PruebaView {
	/**
	 * Menú EditarCompetición:
	 * 1- Nombre de la Competición
	 * 2- Añadir prueba
	 * 3- Editar prueba
	 * 4- Mostrar prueba
	 * 5- Eliminar prueba
	 * 6- Menú participaciones
	 * 7- Salir
	 */
	
	public static void edCompMenu() {
		Utils.print(" ---------- Menú Editar Competición ---------- ");
		Utils.print("|                                             |");
		Utils.print("|                                             |");
		Utils.print("|  {1} Nombre de la competición               |");
		Utils.print("|  {2} Añadir prueba                          |");
		Utils.print("|  {3} Editar prueba                          |");
		Utils.print("|  {4} Mostrar prueba                         |");
		Utils.print("|  {5} Eliminar prueba                        |");
		Utils.print("|  {6} Participantes                          |");
		Utils.print("|  {7} Salir                                  |");
		Utils.print("|                                             |");
		Utils.print(" --------------------------------------------- ");
		
	}
	
	/**
	 * Devolver la opción correcta en el "edCompMenu"
	 */
	
	public static int edCompMenuOp () {
		int op = -1;
		boolean valid = false;
		
		do {
			valid = false;
			op = Utils.leeEntero("Seleccione la opción a elegir: ");
			
			if(op<1 || op>7) {
				
				Utils.print("El valor introducido no es válido, por favor introduzca uno de los siguientes números: ");
				Utils.print(" {1}");
				Utils.print(" {2}");
				Utils.print(" {3}");
				Utils.print(" {4}");
				Utils.print(" {5}");
				Utils.print(" {6}");
				Utils.print(" {7}");
				
				valid = true;
			}
		}while(valid = false);
		
		return op;
	}
	
}
