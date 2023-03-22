package proyectoGimnasia.vistas;

import proyectoGimnasia.interfaces.iGUIPrueba;
//Vista pruebas
public class PruebaView implements iGUIPrueba{
	
	public void showEventMenu() {
		print("+----------------------------------------+");
		print("|         MENU EDITAR COMPETICION        |");
		print("+----------------------------------------+");
		print("|                                        |");
		print("|  {1} Nombre de la competición          |");
		print("|  {2} Añadir prueba                     |");
		print("|  {3} Editar prueba                     |");
		print("|  {4} Mostrar todas las pruebas         |");
		print("|  {5} Mostrar prueba individual         |");
		print("|  {6} Eliminar prueba                   |");
		print("|  {7} Participantes                     |");
		print("|  {8} Volver                            |");
		print("|                                        |");
		print("+----------------------------------------+");
		
	}
	
	
	public void TipoPrueba() {
		print("+----------------------------------------+");
		print("|             AGREGAR PRUEBA             |");
		print("+----------------------------------------+");
		print("|                  TIPO                  |");
		print("|                    |                   |");
		print("+----------------------------------------+");
		print("|                    |                   |");
		print("|     INDIVIDUAL     |       GRUPO       |");
		print("|                    |                   |");
		print("+----------------------------------------+");
	}
	
	public void CategoriaPrueba() {
		print("+----------------------------------------+");
		print("|             AGREGAR PRUEBA             |");
		print("+----------------------------------------+");
		print("|                CATEGORIA               |");
		print("|                    |                   |");
		print("+----------------------------------------+");
		print("|                    |                   |");
		print("|     PREBENJAMIN    |     BENJAMIN      |");
		print("|                    |                   |");
		print("+----------------------------------------+");
		print("|                    |                   |");
		print("|       ALEVIN       |      INFANTIL     |");
		print("|                    |                   |");
		print("+----------------------------------------+");
		print("|                    |                   |");
		print("|       JUNIOR       |       SENIOR      |");
		print("|                    |                   |");
		print("+----------------------------------------+");
	}
	
	public void AparatoPrueba() {
		print("+----------------------------------------+");
		print("|             AGREGAR PRUEBA             |");
		print("+----------------------------------------+");
		print("|                CATEGORIAS              |");
		print("|                    |                   |");
		print("+----------------------------------------+");
		print("|                    |                   |");
		print("|        MAZAS       |        ARO        |");
		print("|                    |                   |");
		print("+----------------------------------------+");
		print("|                    |                   |");
		print("|        CINTA       |       CUERDA      |");
		print("|                    |                   |");
		print("+----------------------------------------+");
		print("|                                        |");
		print("|              MANOS LIBRES              |");
		print("|                                        |");
		print("+----------------------------------------+");
	}
	public static void print (String text) {
		System.out.println(text);
	}
}
