package proyectoGimnasia.vistas;

import proyectoGimnasia.interfaces.iGUIParticipacion;

public class ParticipacionView implements iGUIParticipacion{
	
	public void showParticipationMenu() {
		print(" ---------- Menú Editar Competición ---------- ");
		print("|                                             |");
		print("|                                             |");
		print("|  {1} Añadir participante                    |");
		print("|  {2} Editar participante                    |");
		print("|  {3} Mostrar participantes                  |");
		print("|  {4} Eliminar participantes                 |");
		print("|  {5} Salir                                  |");
		print("|                                             |");
		print(" --------------------------------------------- ");
		
	}
	
	public static void print (String text) {
		System.out.println(text);
	}
}
