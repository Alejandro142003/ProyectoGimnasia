package proyectoGimnasia.controlador;

import java.time.LocalDate;
import java.util.Date;

import proyectoGimnasia.cruds.CompeticionCrud;
import proyectoGimnasia.interfaces.iControllerCompeticion;
import proyectoGimnasia.interfaces.iControllerPrueba;
import proyectoGimnasia.interfaces.iGUICompeticion;
import proyectoGimnasia.interfaces.iRepoCompeticion;
import proyectoGimnasia.interfaces.iRepoPrueba;
import proyectoGimnasia.model.RepoCompeticiones;
import proyectoGimnasia.model.RepoPrueba;
import proyectoGimnasia.model.DTO.Competicion;
import proyectoGimnasia.utils.Utils;
import proyectoGimnasia.vistas.CompeticionView;

public class ControlCompeticion implements iControllerCompeticion{
	private iGUICompeticion guiComp = new CompeticionView();
	private CompeticionCrud compCrud =new CompeticionCrud();
	private ControlPrincipal parent;
	public ControlCompeticion(ControlPrincipal parent) {
		this.parent = parent;
	}
	
	public void controlCompetitionMenu(int op) {
		int option;
		boolean valid = false;
	
		do {
			guiComp.competitionMenu();
			option=Utils.leeEntero("Elije la opcion: ");
			switch(option) {
				case 1:
					controllerAddCompetition();
					break;
				case 2:
					controllerEditCompetition();
					break;
				case 3:
					controllerShowCompetition();
					break;
				case 4:
					controllerDeleteCompetition();
					break;
				case 5:
					controllerShowAllCompetitions();
					break;
				case 6:
					this.parent.cp.controlPruebaMenu(option);
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

	public void controllerAddCompetition() {
		String nombre=Utils.leeString("Introduce el nombre de la competicion: ");
		String descripcion=Utils.leeString("Introduce la descripcion de la competicion: ");
		Date fechaInicio=Utils.validFecha("Introduce la fecha de incio de la competicion: ");
		Competicion nCompeticion = new Competicion(nombre, descripcion, fechaInicio);
		if(compCrud.addCompetition(nCompeticion)==true) {
			Utils.print("Se ha introducido correctamente la competicion.");
		}else {
			Utils.print("No se ha introducido la competicion.");
		}
	}

	public void controllerEditCompetition() {
		compCrud.editCompetition();
		
		
	}
	
	public void controllerDeleteCompetition() {
		
		compCrud.deleteCompetition(compCrud.findCompetition(Utils.leeString("Introduce el nombre de la competicion: ")));
	}
	public void controllerShowCompetition() {
		
		String nombre=Utils.leeString("Introduce el nombre de la competicion que desea mostrar: ");
		compCrud.findCompetition(nombre);
		Utils.printObject(compCrud.findCompetition(nombre));
	}
	
	public void controllerShowAllCompetitions() {
		String competiciones = compCrud.showAll();
		Utils.printObject(competiciones);
	}
}
