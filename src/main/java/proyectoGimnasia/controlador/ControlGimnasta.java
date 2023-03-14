package proyectoGimnasia.controlador;

import proyectoGimnasia.interfaces.iControllerGimnasta;
import proyectoGimnasia.model.RepoGimnastas;

public class ControlGimnasta implements iControllerGimnasta {

	RepoGimnastas RepoGimnstasGrupo = new RepoGimnastas();
	
	private ControlPrincipal parent;
	public ControlGimnasta(ControlPrincipal parent) {
		this.parent = parent;
	}
	
	@Override
	public void controlGymnastMenu(int op) {
		RepoGimnstasGrupo.addGymnast();
		
		
	}

	@Override
	public void executeGymnastMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerAddGymnast() {
		// TODO Auto-generated method stub
		
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
