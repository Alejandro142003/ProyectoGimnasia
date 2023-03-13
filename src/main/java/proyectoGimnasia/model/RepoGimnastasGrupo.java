package proyectoGimnasia.model;

import proyectoGimnasia.model.DTO.Gimnasta;
import proyectoGimnasia.model.DTO.Grupo;
import proyectoGimnasia.model.DTO.Prueba;
import proyectoGimnasia.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import proyectoGimnasia.interfaces.iRepoGimnastaGrupo;

public class RepoGimnastasGrupo implements iRepoGimnastaGrupo {
	private List<Gimnasta> gimnastas;
	private List<Grupo> grupos;
	
	public RepoGimnastasGrupo() {
        gimnastas = new ArrayList<Gimnasta>();
        grupos = new ArrayList<Grupo>();
    }
    
	public void addGymnast() {
		Gimnasta Gimnasta = new Gimnasta();
		int dorsal = Utils.leeEntero("Introduce el numero del dorsal: ");
		Gimnasta.setDorsal(dorsal);
		String dni = Utils.leeString("Introduce el dni: ");
		Gimnasta.setDni(dni);
		String nombre = Utils.leeString("Introduce el nombre: ");
		Gimnasta.setNombre(nombre);
		String correo = Utils.leeString("Introduce un correo electrónico: ");
		Gimnasta.setCorreo(correo);
		int telefono = Utils.leeEntero("Introduce un numero de telefono; ");
		Gimnasta.setTelefono(telefono);
		String categoria = Utils.leeString("Introduce la categoria del Gimnasta: ");
		Gimnasta.setCategoria(categoria);
		String club = Utils.leeString("Introduce el club del Gimnasta: ");
		Gimnasta.setClub(club);
	}

	public void editGymnast() {
		Gimnasta Gimnasta = null;
		int dorsal = Utils.leeEntero("Introduce el numero del dorsal: ");
		Gimnasta.setDorsal(dorsal);
		String dni = Utils.leeString("Introduce el dni: ");
		Gimnasta.setDni(dni);
		String nombre = Utils.leeString("Introduce el nombre: ");
		Gimnasta.setNombre(nombre);
		String correo = Utils.leeString("Introduce un correo electrónico: ");
		Gimnasta.setCorreo(correo);
		int telefono = Utils.leeEntero("Introduce un numero de telefono; ");
		Gimnasta.setTelefono(telefono);
		String categoria = Utils.leeString("Introduce la categoria del Gimnasta: ");
		Gimnasta.setCategoria(categoria);
		String club = Utils.leeString("Introduce el club del Gimnasta: ");
		Gimnasta.setClub(club);
	}

	public void deleteGymnast() {
		// TODO Auto-generated method stub
		
	}

	public void showGymnast() {
		Gimnasta.toString();
		
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
		Grupo.toString();
	}
	
	public void deleteGroup() {
		//TODO
	}
}
