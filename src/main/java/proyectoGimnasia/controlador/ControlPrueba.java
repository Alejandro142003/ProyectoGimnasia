package proyectoGimnasia.controlador;

import java.util.List;

import proyectoGimnasia.interfaces.iControllerPrueba;
import proyectoGimnasia.interfaces.iGUIPrueba;
import proyectoGimnasia.model.RepoPrueba;
import proyectoGimnasia.model.DTO.Prueba;
import proyectoGimnasia.utils.Utils;
import proyectoGimnasia.vistas.PruebaView;




public class ControlPrueba implements iControllerPrueba {

	private ControlPrincipal parent;
	public ControlPrueba(ControlPrincipal parent) {
		this.parent = parent;
	}
	
	RepoPrueba repoPrueba = new RepoPrueba();
	private iGUIPrueba vistaprueba = new PruebaView();


	@Override
	public void controlPruebaMenu(int op) {
		int option;
		boolean valid = false;
	
		do {
			vistaprueba.showEventMenu();
			option=Utils.leeEntero("Elije la opcion: ");
			switch(option) {
				case 1:
					//falta llamar al nombre de competición actual
					break;
				case 2:
					controllerAgregarPrueba();
					break;
				case 3:
					controllerEditarPrueba();
					break;
				case 4:
					controllerMostrarPrueba();
					break;
				case 5:
					controllerEliminarPrueba();
					break;
				case 6:
					this.parent.cpart.controlPartitionMenu(option);
					break;
				case 7:
					valid=true;
					Utils.print("Has salido correctamente del menu competicion.");
					break;
					
				default:
					Utils.print("Opción incorrecta");
					break;
			}
		}while(!valid);
		
		
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
	    repoPrueba.MostrarPrueba();
	}

	
}
