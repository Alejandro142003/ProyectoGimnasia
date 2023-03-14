package proyectoGimnasia.controlador;

import proyectoGimnasia.interfaces.iGUI;
import proyectoGimnasia.utils.Utils;
import proyectoGimnasia.vistas.MainView;

public class ControlPrincipal<T> {
	public ControlPrueba cp = new ControlPrueba(this);
	public ControlCompticion cpp =new ControlCompticion(this);
	public ControlParticipacion<T> cpart= new ControlParticipacion(this);
	public ControlGimnasta cGim= new ControlGimnasta(this);
	public ControlGimnastaGrupo cGimGrup= new ControlGimnastaGrupo(this);
	public ControlGrupo cGrupo= new ControlGrupo(this);
	private iGUI mainView = new MainView();
	
	
	public void controllerMainMenu() {
		boolean valid = false;
		int option;
		do {
			mainView.showMainMenu();
			option=Utils.leeEntero("Introduce una opción: ");
			switch(option) {
			case 1:
				cpp.controlCompetitionMenu(option);
				break;
			case 2:
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
