package proyectoGimnasia.controlador;

import java.util.ArrayList;
import java.util.List;

import proyectoGimnasia.cruds.GimnastasCrud;
import proyectoGimnasia.cruds.GruposCrud;
import proyectoGimnasia.interfaces.iControllerGrupo;
import proyectoGimnasia.interfaces.iGUIGrupo;
import proyectoGimnasia.model.DTO.Gimnasta;
import proyectoGimnasia.model.DTO.Grupo;
import proyectoGimnasia.utils.Utils;
import proyectoGimnasia.vistas.GrupoView;

public class ControlGrupo implements iControllerGrupo{
	
	private iGUIGrupo guiGru = new GrupoView();
	GruposCrud grc= new GruposCrud();
	GimnastasCrud gc= new GimnastasCrud();
	
	private ControlPrincipal parent;
	public ControlGrupo(ControlPrincipal parent) {
		this.parent = parent;
	}
	
	@Override
	public void controlGrouptMenu(int op) {
		int opt;
		boolean salir = false;
		
		do {
			guiGru.showGroupMenu();
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
		ArrayList<Gimnasta> gimnastas = new ArrayList<Gimnasta>();
		String Nombre = Utils.leeString("Introduce el nombre del grupo: ");
		String club = Utils.leeString("Introduce el nombre del club:");
		String dni = Utils.leeString("Introduce el dni del gimnasata que quiere añadir al grupo: ");
		gimnastas.add(gc.findGymnast(dni));
		boolean salir = false;
		do {
			int op = Utils.leeEntero("¿Quiere añadir otro gimnasta al grupo?  1. Sí | 2. No \n");
				if(op == 1) {
					String dni2 = Utils.leeString("Introduce el dni del gimnasta que quiere añadir al grupo: ");
					gimnastas.add(gc.findGymnast(dni2));
				} else {
					salir = true;
				}
		} while(!salir);
		Grupo grupo = new Grupo(Nombre,club);
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
		int op = 0;
		boolean salir = false;
		Grupo gr = null;
		gr = (Grupo) grc.findGroup(Utils.leeString("Introduce el nombre del grupo: "));
		String nombre = Utils.leeString("Introduce el nuevo nombre del grupo: ");
		gr.setGroupName(nombre);
		String club = Utils.leeString("Introduce el nuevo club del grupo: ");
		gr.setClub(club);
		List<Gimnasta> gimnastas = gr.getListGimnasta();
		do {
			guiGru.showGymnastGroupMenu();
			Utils.print("");
			switch(op) {
				case 1:
					//Añadir un Gimnasta al ArrayList del grupo.
					Gimnasta g = null;
					String dni = Utils.leeString("Introduce el dni del gimnasta que desea mostrar: ");
					if (gc.findGymnast(dni) == null) {
						Utils.print("El dni que ha introducido no existe.");
					} else {
						g = gc.findGymnast(dni);
						if(gimnastas.add(g) == true) {
							Utils.print("El gimnasta se ha introducido correctamente en el grupo.");
						} else  {
							Utils.print("El gimnasta no se ha podido introducir en el grupo.");
						}
					}
					break;
				case 2:
					//Eliminar un Gimnasta del ArrayList del grupo.
					Gimnasta g2 = null;
					String dni2 = Utils.leeString("Introduce el dni del gimnasta que desea mostrar: ");
					if (gc.findGymnast(dni2) == null) {
						Utils.print("El dni que ha introducido no existe.");
					} else {
						g2 = gc.findGymnast(dni2);
						if(gimnastas.remove(g2)==true) {
							Utils.print("El gimnasta se ha eliminado correctamente del grupo.");
						} else {
							Utils.print("El gimnasta no se ha podido eliminar del grupo.");
						}
					}
					break;
				case 3:
					salir = true;
					break;
				default:
					Utils.print("Escoja una opción valida");
			}
		} while(!salir);
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
		}
		
	}
	public void controllerShowAllGroups() {
		String grupos = grc.showAllGroups();
		Utils.printObject(grupos);
	}
}
