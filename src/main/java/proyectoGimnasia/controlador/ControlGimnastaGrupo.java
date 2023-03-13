package proyectoGimnasia.controlador;

import proyectoGimnasia.interfaces.iControllerGimnastaGrupo;
import proyectoGimnasia.model.RepoGimnastasGrupo;

public class ControlGimnastaGrupo implements iControllerGimnastaGrupo {

	RepoGimnastasGrupo RepoGimnstasGrupo = new RepoGimnastasGrupo();
	
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

	@Override
	public void executeGroupMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controlGroupMenu(int op) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contorllerAddGroup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerEditGroup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerShowGroup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerDeleteGroup() {
		// TODO Auto-generated method stub
		
	}
}
