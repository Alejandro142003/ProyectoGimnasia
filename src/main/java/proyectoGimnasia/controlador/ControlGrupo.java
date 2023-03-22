package proyectoGimnasia.controlador;

import java.util.ArrayList;
import java.util.List;

import proyectoGimnasia.cruds.GimnastasCrud;
import proyectoGimnasia.cruds.GruposCrud;
import proyectoGimnasia.interfaces.iControllerGrupo;
import proyectoGimnasia.interfaces.iGUIGimnasta;
import proyectoGimnasia.interfaces.iGUIGrupo;
import proyectoGimnasia.model.DTO.Gimnasta;
import proyectoGimnasia.model.DTO.Grupo;
import proyectoGimnasia.utils.Utils;
import proyectoGimnasia.vistas.GimnastaView;
import proyectoGimnasia.vistas.GrupoView;

public class ControlGrupo implements iControllerGrupo{
	
	private iGUIGimnasta guiGim = new GimnastaView();
	private iGUIGrupo guiGru = new GrupoView();
	GruposCrud grc= new GruposCrud();
	
	private ControlPrincipal parent;
	public ControlGrupo(ControlPrincipal parent) {
		this.parent = parent;
	}
	
	@Override
	public void controlGrouptMenu(int op) {
		int opt;
		boolean salir = false;
		
		do {
			guiGim.showGymnastMenu();
			opt=Utils.leeEntero("Elije una opción: ");
			Utils.print("");
			switch(opt) {
				case 1:
					controllerAddGroup();
					break;
					
				case 2:
					controllerEditGroup();
					break;
					
				case 3:
					controllerShowGroup();
					break;

				case 4:
					controllerShowAllGroups();
					break;
					
				case 5:
					controllerDeleteGroup();
					break;
					
				case 6:
					Utils.print("");
					salir = true;
					break;
					
				default:
					Utils.print("Escoja una opción correcta: ");
					break;
			}
		}while(!salir);
	}
		
	@Override
	public void controllerAddGroup() {
		String Nombre = Utils.leeString("Introduce el nombre del grupo: ");
		String club = Utils.leeString("Introduce el nombre del club:");
		//Añadir array del gimnastas
		
		ArrayList<Gimnasta> gimnastas = new ArrayList<Gimnasta>();
		Grupo grupo = new Grupo(Nombre,club, gimnastas);
		if(grc.addGroup(grupo)==true) {
			Utils.print("Se ha introducido correctamente el gimnasta.");
		}else {
			Utils.print("No se ha introducido el gimnasta.");
		}
		
	}
	@Override
	public void controllerEditGroup() {
		controllerShowAllGroups();
		Utils.print("");
		Grupo gr = null;
		gr = (Grupo) grc.findGroup(Utils.leeString("Introduce el nombre del grupo: "));
		String nombre = Utils.leeString("Introduce el nuevo nombre del grupo: ");
		gr.setGroupName(nombre);
		String club = Utils.leeString("Introduce el nuevo club del grupo: ");
		gr.setClub(club);
		//Modificar gimnastas.
		if(grc.editGroup(gr)) {
			Utils.print("Se ha actualizado correctamente.");
			Utils.print("");
		}else {
			Utils.print("No se ha actualizado la competicion.");
			Utils.print("");
		} 
		
	}
	@Override
	public void controllerShowGroup() {
		String name = Utils.leeString("Introduce el nombre del grupo que desea mostrar: ");
		grc.findGroup(name);
		if (grc.findGroup(name) == null) {
			Utils.print("El nombre que ha introducido no existe.");
		} else {
			Utils.printObject(grc.findGroup(name));
			Utils.print("");
			}
		}
		
	@Override
	public void controllerDeleteGroup() {
		controllerShowAllGroups();
		String nombre = Utils.leeString("Introduce el nombre del grupo que desea eliminar: ");
		if (grc.deleteGroup(grc.findGroup(nombre))) {
			Utils.print("Se ha eliminado correctamente.");
			Utils.print("");
		} else {
			Utils.print("No se ha podido eliminar el grupo");
			Utils.print("");
		}// TODO Auto-generated method stub
		
	}
	public void controllerShowAllGroups() {
		String grupos = grc.showAllGroups();
		Utils.printObject(grupos);
	}
}
