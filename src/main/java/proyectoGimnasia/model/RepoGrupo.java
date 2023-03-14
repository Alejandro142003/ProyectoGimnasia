package proyectoGimnasia.model;

import java.util.ArrayList;
import java.util.List;

import proyectoGimnasia.interfaces.iRepoGrupo;
import proyectoGimnasia.model.DTO.Gimnasta;
import proyectoGimnasia.model.DTO.Grupo;
import proyectoGimnasia.utils.Utils;

public class RepoGrupo implements iRepoGrupo{
	private List<Grupo> grupos;
	
	public RepoGrupo() {
		grupos = new ArrayList<Grupo>();
    }

	public void addGroup() {
		
		String nombre = Utils.leeString("Introduce el nombre del grupo: ");
		String club = Utils.leeString("Introduce el nombre del club: ");
		//ArrayList se usa en el controlador para añadir a los gimnastas preguntando si quiere añadir 
		//otro mas cada vez que añade uno.
	}
	
	public void editGroup() {
		String nombre = Utils.leeString("Introduce el nombre del grupo: ");
		String club = Utils.leeString("Introduce el nombre del club: ");
		//ArrayList se usa en el controlador para añadir a los gimnastas preguntando si quiere añadir 
		//otro mas cada vez que añade uno.
	}
	
	public void showGroup() {
		
	}
	
	public void deleteGroup() {
		//TODO
	}
}
