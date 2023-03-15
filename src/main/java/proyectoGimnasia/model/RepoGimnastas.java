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
	private ArrayList<Gimnasta> gimnastas = new ArrayList<Gimnasta>();
    
	public boolean addGymnast(Gimnasta gimnasta) {
		
		boolean result=false;
		if(!gimnastas.contains(gimnasta) && gimnasta.getNombre()==null) {
			gimnastas.add(gimnasta);
			result=true;
		}
		return result;

	}

	public void editGymnast() {
		//TODO
		
	}

	public void deleteGymnast() {
		// TODO Auto-generated method stub
		
	}

	public void showGymnast() {
		
	}
}
