package proyectoGimnasia.vistas;

import proyectoGimnasia.interfaces.iGUIPrueba;
//Vista pruebas
public class PruebaView implements iGUIPrueba{
	
	public void showEventMenu() {
		print(" ---------- Menú Editar Competición ---------- ");
		print("|                                             |");
		print("|                                             |");
		print("|  {1} Nombre de la competición               |");
		print("|  {2} Añadir prueba                          |");
		print("|  {3} Editar prueba                          |");
		print("|  {4} Mostrar prueba                         |");
		print("|  {5} Eliminar prueba                        |");
		print("|  {6} Participantes                          |");
		print("|  {7} Salir                                  |");
		print("|                                             |");
		print(" --------------------------------------------- ");
		
	}
	
	public static void print (String text) {
		System.out.println(text);
	}
}
