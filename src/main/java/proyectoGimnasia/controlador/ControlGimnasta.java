package proyectoGimnasia.controlador;

import proyectoGimnasia.interfaces.iControllerGimnasta;
import proyectoGimnasia.interfaces.iGUIGimnasta;
import proyectoGimnasia.interfaces.iGUIGrupo;
import proyectoGimnasia.interfaces.iRepoGimnasta;
import proyectoGimnasia.vistas.GimnastaView;
import proyectoGimnasia.vistas.GrupoView;
import proyectoGimnasia.model.RepoGimnastas;
import proyectoGimnasia.model.DTO.Gimnasta;
import proyectoGimnasia.utils.Utils;

public class ControlGimnasta implements iControllerGimnasta {
	private iRepoGimnasta repoGim = new RepoGimnastas();
	
	private iGUIGimnasta guiGim = new GimnastaView();
	private iGUIGrupo guiGru = new GrupoView();
	RepoGimnastas RepoGimnstasGrupo = new RepoGimnastas();
	
	private ControlPrincipal parent;
	public ControlGimnasta(ControlPrincipal parent) {
		this.parent = parent;
	}
	
	@Override
	public void controlGymnastMenu(int op) {
		int opt;
		boolean salir = false;
		
		do {
			guiGim.showGymnastMenu();
			opt=Utils.leeEntero("Elije una opción: ");
			switch(opt) {
				case 1:
					controllerAddGymnast();
					break;
					
				case 2:
					controllerEditGymnast();
					break;
					
				case 3:
					controllerShowGymnast();
					break;
					
				case 4:
					controllerDeleteGymnast();
					break;
					
				default:
					Utils.print("Escoja una opción correcta: ");
					break;
			}
		}while(!salir);
	}

	@Override
	public void controllerAddGymnast() {
		
		String dni = Utils.leeString("Introduce el dni: ");
		String nombre = Utils.leeString("Introduce el nombre: ");
		String correo = Utils.leeString("Introduce un correo electrónico: ");
		int telefono = Utils.leeEntero("Introduce un numero de telefono; ");
		String categoria = Utils.leeString("Introduce la categoria del Gimnasta: ");
		String club = Utils.leeString("Introduce el club del Gimnasta: ");
		int dorsal = Utils.leeEntero("Introduce el numero del dorsal: ");
		Gimnasta Gimnasta = new Gimnasta(dni,nombre,correo,telefono,categoria,club,dorsal);
		if(repoGim.addGymnast(Gimnasta)==true) {
			Utils.print("Se ha introducido correctamente el gimnasta.");
		}else {
			Utils.print("No se ha introducido el gimnasta.");
		}
	}

	@Override
	public void controllerEditGymnast() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerShowGymnast() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerDeleteGymnast() {
		// TODO Auto-generated method stub
		
	}
}
