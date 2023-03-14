package proyectoGimnasia.model;

import proyectoGimnasia.model.DTO.Gimnasta;
import proyectoGimnasia.model.DTO.Grupo;
import proyectoGimnasia.model.DTO.Prueba;
import proyectoGimnasia.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import proyectoGimnasia.interfaces.iRepoGimnasta;

public class RepoGimnastas implements iRepoGimnasta{
	private List<Gimnasta> gimnastas;
	
	public RepoGimnastas() {
        gimnastas = new ArrayList<Gimnasta>();
        
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
		
	}
}
