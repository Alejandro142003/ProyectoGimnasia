package proyectoGimnasia.controlador;

import proyectoGimnasia.cruds.GimnastasCrud;
import proyectoGimnasia.interfaces.iControllerGimnasta;
import proyectoGimnasia.interfaces.iGUIGimnasta;
import proyectoGimnasia.interfaces.iGUIGrupo;
import proyectoGimnasia.vistas.GimnastaView;
import proyectoGimnasia.vistas.GrupoView;
import proyectoGimnasia.model.DTO.Gimnasta;
import proyectoGimnasia.utils.Utils;

public class ControlGimnasta implements iControllerGimnasta {
	
	private iGUIGimnasta guiGim = new GimnastaView();
	private iGUIGrupo guiGru = new GrupoView();
	GimnastasCrud gc= new GimnastasCrud();
	
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
			Utils.print("");
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
					controllerShowAllGymnast();
					break;
					
				case 5:
					controllerDeleteGymnast();
					break;
					
				case 6:
					this.parent.cGrupo.controlGrouptMenu(opt);
					break;
					
				case 7:
					controllerShowAllGymnast();
					this.parent.cGrupo.controllerShowAllGroups();
					break;
					
				case 8:
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
	public void controllerAddGymnast() {
		
		String dni = Utils.leeString("Introduce el dni: ");
		String nombre = Utils.leeString("Introduce el nombre: ");
		String correo = Utils.leeString("Introduce un correo electrónico: ");
		int telefono = Utils.leeEntero("Introduce un numero de telefono; ");
		String categoria = Utils.leeString("Introduce la categoria del Gimnasta: ");
		String club = Utils.leeString("Introduce el club del Gimnasta: ");
		int edad = Utils.leeEntero("Introduce la edad del Gimnasta: ");
		Gimnasta Gimnasta = new Gimnasta(dni,nombre,correo,telefono,categoria,club,edad);
		if(gc.addGymnast(Gimnasta)==true) {
			Utils.print("Se ha introducido correctamente el gimnasta.");
		}else {
			Utils.print("No se ha introducido el gimnasta.");
		}
	}

	@Override
	public void controllerEditGymnast() {
		controllerShowAllGymnast();
		Utils.print("");
		Gimnasta g = null;
		g = (Gimnasta) gc.findGymnast(Utils.leeString("Introduce el nombre del gimnasta: "));
		String nombre = Utils.leeString("Introduce el nuevo nombre: ");
		g.setNombre(nombre);
		String correo = Utils.leeString("Introduce el nuevo correo: ");
		g.setCorreo(correo);
		int telefono = Utils.leeEntero("Introduce el nuevo telefono: ");
		g.setTelefono(telefono);
		String categoria = Utils.leeString("Introduce la nueva categoria: ");
		g.setCategoria(categoria);
		String club = Utils.leeString("Introduce el nuevo club: ");
		g.setClub(club);
		int edad = Utils.leeEntero("Introduce la edad del partcipante: ");
		g.setEdad(edad);
		if(gc.editGymnast(g)) {
			Utils.print("Se ha actualizado correctamente.");
			Utils.print("");
		}else {
			Utils.print("No se ha actualizado la competicion.");
			Utils.print("");
		} 
	}

	@Override
	public void controllerShowGymnast() {
		String dni = Utils.leeString("Introduce el dni del gimnasta que desea mostrar: ");
		gc.findGymnast(dni);
		if (gc.findGymnast(dni) == null) {
			Utils.print("El dni que ha introducido no existe.");
		} else {
			Utils.printObject(gc.findGymnast(dni));
			Utils.print("");
			}
		}

	@Override
	public void controllerDeleteGymnast() {
		controllerShowAllGymnast();
		String dni = Utils.leeString("Introduce el dni del gimnasta que desea eliminar: ");
		if (gc.deleteGymnast(gc.findGymnast(dni))) {
			Utils.print("Se ha eliminado correctamente.");
			Utils.print("");
		} else {
			Utils.print("No se ha podido eliminar el gimnasta");
			Utils.print("");
		}
	}
	
	public void controllerShowAllGymnast() {
		String gimnastas = gc.showAllGymnasts();
		Utils.printObject(gimnastas);
	}
}
