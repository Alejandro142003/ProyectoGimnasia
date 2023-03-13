package proyectoGimnasia.vistas;

import proyectoGimnasia.interfaces.iGUIGrupo;

public class GrupoView implements iGUIGrupo{

	public void showGroupMenu() {
		print(" ---------- Menú Grupos ---------- ");
		print("|                                 |");
		print("|                                 |");
		print("|  {1} Añadir grupo               |");
		print("|  {2} Editar grupo               |");
		print("|  {3} Eliminar grupo             |");
		print("|  {4} Salir                      |");
		print("|                                 |");
		print(" --------------------------------- ");
		
	}
	
	public static void print (String text) {
		System.out.println(text);
	}
}
