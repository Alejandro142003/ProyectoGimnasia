package proyectoGimnasia.controlador;

import java.time.LocalDate;

import proyectoGimnasia.interfaces.iControllerCompeticion;
import proyectoGimnasia.interfaces.iControllerPruba;
import proyectoGimnasia.interfaces.iRepoCompeticion;
import proyectoGimnasia.interfaces.iRepoPrueba;
import proyectoGimnasia.model.RepoCompeticiones;
import proyectoGimnasia.model.RepoPrueba;
import proyectoGimnasia.model.DTO.Competicion;
import proyectoGimnasia.utils.Utils;

public class ControlCompticion implements iControllerCompeticion{
	private iRepoCompeticion repoComp = new RepoCompeticiones();

	public void controlCompetitionMenu(int op) {
		int option;
		boolean valid = false;
	
		do {
			
			option=Utils.leeEntero("Elije la opcion: ");
			switch(option) {
				case 0:
					valid=true;
					Utils.print("Has salido correctamente del menu competicion.");
					break;
				case 1:
					controllerAddCompetition();
					break;
				case 2:
					controllerEditCompetition();
					break;
				case 3:
					controllerShowCompetition();
					break;
				default:
					Utils.print("Opción incorrecta");
					break;
			}
		}while(!valid);
		
		
	}

	public void controllerAddCompetition() {
		String nombre=Utils.leeString("Introduce el nombre de la competicion: ");
		String descripcion=Utils.leeString("Introduce la descripcion de la competicion: ");
		LocalDate fechaInicio=null;
		Competicion nCompeticion = new Competicion(nombre, descripcion, fechaInicio);
		if(repoComp.addCompetition(nCompeticion)==true) {
			Utils.print("Se ha introducido correctamente la competicion.");
		}else {
			Utils.print("No se ha introducido la competicion.");
		}
	}

	public void controllerEditCompetition() {
		Competicion c = null;
		c = (Competicion) repoComp.showCompetition(Utils.leeString("Introduce el nombre de la que competicion que desea editar: "));
		String descripcion = Utils.leeString("Introduce la nueva descripcion de la competicion: ");
		LocalDate fechaInicio = null;
		
		c.setDescripcion(descripcion);
		c.setFechaInicio(fechaInicio);
		
		
	}

	public void controllerShowCompetition() {
		
		String nombre=Utils.leeString("Introduce el nombre de la competicion que desea mostrar: ");
		repoComp.showCompetition(nombre);
	}

}
