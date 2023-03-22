package proyectoGimnasia.vistas;

import proyectoGimnasia.interfaces.iGUICompeticion;

public class CompeticionView implements iGUICompeticion{
	
	public void competitionMenu() {
		print("+----------------------------------------+");
		print("|            MENU COMPETICION            |");
		print("+----------------------------------------+");
		print("|                                        |");
		print("|  {1} Crear competición                 |");
		print("|  {2} Editar competición                |");
		print("|  {3} Mostrar competición               |");
		print("|  {4} Eliminar competición              |");
		print("|  {5} Mostrar todas competiciones       |");
		print("|  {6} Menu Pruebas                      |");
		print("|  {7} Volver                             |");
		print("|                                        |");
		print("+----------------------------------------+");
		
	}
	
	public static void print (String text) {
		System.out.println(text);
	}
}
