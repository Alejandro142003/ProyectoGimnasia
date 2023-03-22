package proyectoGimnasia.vistas;

import proyectoGimnasia.interfaces.iGUIGrupo;

public class GrupoView implements iGUIGrupo{

	public void showGroupMenu() {
		print("+----------------------------------------+");
		print("|               MENU GRUPOS              |");
		print("+----------------------------------------+");
		print("|                                        |");
		print("|  {1} Añadir grupo                      |");
		print("|  {2} Editar grupo                      |");
		print("|  {3} Mostrar grupo                     |");
		print("|  {4} Mostrar todos los grupos          |");
		print("|  {5} Eliminar grupo                    |");
		print("|  {6} Volver                            |");
		print("|                                        |");
		print("+----------------------------------------+");
		
	}
	
	
	public void showGymnastGroupMenu() {
		print("+----------------------------------------+");
		print("|      MENU EDITAR GIMNASTAS GRUPO       |");
		print("+----------------------------------------+");
		print("|                                        |");
		print("|  {1} Añadir gimnasta al grupo          |");
		print("|  {2} Eliminar gimnasta del grupo       |");
		print("|  {3} Volver                            |");
		print("|                                        |");
		print("+----------------------------------------+");
		
	}
	
	public static void print (String text) {
		System.out.println(text);
	}
}
