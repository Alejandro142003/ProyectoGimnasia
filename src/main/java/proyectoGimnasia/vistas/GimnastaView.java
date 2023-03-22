package proyectoGimnasia.vistas;

import proyectoGimnasia.interfaces.iGUIGimnasta;

public class GimnastaView implements iGUIGimnasta{
	
	public void showGymnastMenu() {
		print("+----------------------------------------+");
		print("|            MENU PARTICIPANTES          |");
		print("+----------------------------------------+");
		print("|                                        |");
		print("|                                        |");
		print("|  {1} Añadir gimnasta                   |");
		print("|  {2} Editar gimnasta                   |");
		print("|  {3} Mostrar gimnastas/grupos          |");
		print("|  {4} Eliminar gimansta                 |");
		print("|  {5} Grupo                             |");
		print("|  {6} Volver                             |");
		print("|                                        |");
		print("+----------------------------------------+");
		
	}
	
	//método
	
	public static void print (String text) {
		System.out.println(text);
	}

	
}
