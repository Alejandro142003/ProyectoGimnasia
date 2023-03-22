package proyectoGimnasia.controlador;

import proyectoGimnasia.cruds.PruebaCrud;
import proyectoGimnasia.interfaces.iGUI;
import proyectoGimnasia.model.RepoCompeticiones;
import proyectoGimnasia.model.RepoGimnasta;
import proyectoGimnasia.utils.Utils;
import proyectoGimnasia.vistas.MainView;

public class ControlPrincipal<T> {
	public ControlPrueba cp = new ControlPrueba(this);
	public ControlCompeticion cpp =new ControlCompeticion(this);
	public ControlParticipacion<T> cpart= new ControlParticipacion(this);
	public ControlGimnasta cGim= new ControlGimnasta(this);
	public ControlGimnastaGrupo cGimGrup= new ControlGimnastaGrupo(this);
	public ControlGrupo cGrupo= new ControlGrupo(this);
	private iGUI mainView = new MainView();
	
	
	public void controllerMainMenu() {
		RepoCompeticiones rp = RepoCompeticiones.newInstance();
		RepoGimnasta rg = RepoGimnasta.newInstance();
		
	
		boolean valid = false;
		int option;
		do {
			mainView.showMainMenu();
			option=Utils.leeEntero("Introduce una opción: ");
			Utils.print("");
			switch(option) {
			case 1:
				cpp.controlCompetitionMenu(option);
				break;
			case 2:
				cGim.controlGymnastMenu(option);
				//Falta implementar el controlador de gimnasta grupo cGimGrup.controlGimnastaGrupo();
				break;
			case 3:
				valid=true;
				Utils.print("Has salido del programa.");
				break;
			default:
				Utils.print("Opción incorrecta");
				break;	
			}
		}while(!valid);
		
	}
	
}
