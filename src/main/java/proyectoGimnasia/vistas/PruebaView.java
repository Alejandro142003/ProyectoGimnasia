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
	
	
	public void TipoPrueba() {
		print(" ----------   Agregar Prueba        ---------- ");
		print("|                  Tipo                       |");
		print("|                    |                        |");
		print(" --------------------------------------------- ");
		print("|                    |                        |");
		print("|  {1} Invividual    |        {2} Grupo       |");
		print("|                    |                        |");
		print(" --------------------------------------------- ");
	}
	
	public void CategoriaPrueba() {
		print(" ----------    Agregar Prueba       ---------- ");
		print("|                Categoria                    |");
		print("|                    |                        |");
		print(" --------------------------------------------- ");
		print("|                    |                        |");
		print("|  {1} Prebenjamin   |     {2} Benjamin       |");
		print("|                    |                        |");
		print(" --------------------------------------------- ");
		print("|                    |                        |");
		print("|  {3} Alevin        |     {4} Infantil       |");
		print("|                    |                        |");
		print(" --------------------------------------------- ");
		print("|                    |                        |");
		print("|  {5} Junior        |     {6} Senior         |");
		print("|                    |                        |");
		print(" --------------------------------------------- ");
	}
	
	public void AparatoPrueba() {
		print(" ----------   Agregar Prueba        ---------- ");
		print("|                Categoria                    |");
		print("|                    |                        |");
		print(" --------------------------------------------- ");
		print("|                    |                        |");
		print("|  {1} Mazas         |     {2} Aro            |");
		print("|                    |                        |");
		print(" --------------------|----------------------- ");
		print("|                    |                        |");
		print("|  {3} Cinta         |     {4} Cuerda         |");
		print("|                    |                        |");
		print(" --------------------------------------------- ");
		print("|                                             |");
		print("|           {5} ManosLibres                   |");
		print("|                                            |");
		print(" --------------------------------------------- ");
	}
	public static void print (String text) {
		System.out.println(text);
	}
}
