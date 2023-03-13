package proyectoGimnasia.vistas;

import proyectoGimnasia.interfaces.iGUI;

public class MainView implements iGUI{
	
	
	
	public void showMainMenu() {
		print(" ---------- Menú Principal ---------- ");
		print("|                                    |");
		print("|                                    |");
		print("|  {1} Competición                   |");
		print("|  {2} Participantes                 |");
		print("|  {3} Salir                         |");
		print("|                                    |");
		print(" ------------------------------------ ");
		
	}
	
	public static void print (String text) {
		System.out.println(text);
	}

	
}
