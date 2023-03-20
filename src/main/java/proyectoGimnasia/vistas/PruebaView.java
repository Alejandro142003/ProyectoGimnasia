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
		print("|  {4} Mostrar todas las pruebas              |");
		print("|  {5} Mostrar prueba individual              |");
		print("|  {6} Eliminar prueba                        |");
		print("|  {7} Participantes                          |");
		print("|  {8} Salir                                  |");
		print("|                                             |");
		print(" --------------------------------------------- ");
		
	}
	
	
	public void TipoPrueba() {
		print(" ----------   Agregar Prueba        ---------- ");
		print("|                  Tipo                       |");
		print("|                    |                        |");
		print(" --------------------------------------------- ");
		print("|                    |                        |");
		print("|      Invividual    |            Grupo       |");
		print("|                    |                        |");
		print(" --------------------------------------------- ");
	}
	
	public void CategoriaPrueba() {
		print(" ----------    Agregar Prueba       ---------- ");
		print("|                Categoria                    |");
		print("|                    |                        |");
		print(" --------------------------------------------- ");
		print("|                    |                        |");
		print("|      Prebenjamin   |         Benjamin       |");
		print("|                    |                        |");
		print(" --------------------------------------------- ");
		print("|                    |                        |");
		print("|      Alevin        |         Infantil       |");
		print("|                    |                        |");
		print(" --------------------------------------------- ");
		print("|                    |                        |");
		print("|      Junior        |         Senior         |");
		print("|                    |                        |");
		print(" --------------------------------------------- ");
	}
	
	public void AparatoPrueba() {
		print(" ----------   Agregar Prueba        ---------- ");
		print("|                Categoria                    |");
		print("|                    |                        |");
		print(" --------------------------------------------- ");
		print("|                    |                        |");
		print("|      Mazas         |         Aro            |");
		print("|                    |                        |");
		print(" --------------------|----------------------- ");
		print("|                    |                        |");
		print("|      Cinta         |         Cuerda         |");
		print("|                    |                        |");
		print(" --------------------------------------------- ");
		print("|                                             |");
		print("|              ManosLibres                    |");
		print("|                                             |");
		print(" --------------------------------------------- ");
	}
	public static void print (String text) {
		System.out.println(text);
	}
}
