package proyectoGimnasia.controlador;

import java.util.List;

import proyectoGimnasia.interfaces.iControllerPruba;
import proyectoGimnasia.model.RepoPrueba;
import proyectoGimnasia.model.DTO.Prueba;
import proyectoGimnasia.utils.Utils;




public class ControlPrueba implements iControllerPruba {

	
	RepoPrueba repoPrueba = new RepoPrueba();

	@Override
	public void executePruebaMenu() {
	    int opcion = 0;
	    do {
	        System.out.println("Menú de Pruebas:");
	        System.out.println("*      1. Agregar Prueba      *");
	        System.out.println("*      2. Mostrar Pruebas     *");
	        System.out.println("*      3. Editar Prueba       *");
	        System.out.println("*      4. Eliminar Prueba     *");
	        System.out.println("*      0. Salir               *");

	        opcion = Utils.leeEntero("Seleccione una opción: ");
	        controlPruebaMenu(opcion);
	    } while (opcion != 0);
	}


	@Override
	public void controlPruebaMenu(int op) {
	    switch (op) {
	        case 0:
	            System.out.println("Has elegido salir de prueba");
	            break;
	        case 1:
	            controllerAgregarPrueba();
	            break;
	        case 2:
	            controllerEliminarPrueba();
	            break;
	        case 3:
	            controllerEditarPrueba();
	            break;
	        case 4:
	            controllerMostrarPrueba();
	            break;
	        default:
	            System.out.println("Selecione una opción válida");
	            break;
	    }
	}

	@Override
	public void controllerAgregarPrueba() {
	    repoPrueba.AgregarPrueba();
	}

	@Override
	public void controllerEditarPrueba() {
	    repoPrueba.EditarPrueba(null, null, null, null);
	}


	@Override
	public void controllerEliminarPrueba() {
	    repoPrueba.EliminarPrueba();
	}


	@Override
	public void controllerMostrarPrueba() {
	    List<Prueba> pruebas = repoPrueba.MostrarPrueba();
	    if (pruebas.size() == 0) {
	        System.out.println("No hay pruebas registradas en el sistema.");
	    } else {
	        System.out.println("Lista de pruebas registradas:");
	        for (Prueba p : pruebas) {
	            System.out.println(p.toString());
	        }
	    }
	}

	
}
