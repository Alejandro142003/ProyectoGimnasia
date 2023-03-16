package proyectoGimnasia.model;

import java.util.ArrayList;

import proyectoGimnasia.interfaces.iRepoCompeticion;
import proyectoGimnasia.model.DTO.Competicion;

public class RepoCompeticiones implements iRepoCompeticion{
	private ArrayList<Competicion> competiciones = new ArrayList<Competicion>();
	
	public boolean addCompetition(Competicion competicion) {
		boolean result=false;
		if(!competiciones.contains(competicion)) {
			competiciones.add(competicion);
			result=true;
		}
		return result;
	}

	


	public Competicion showCompetition(String nombre) {
		Competicion c = null;
		for(Competicion com:competiciones) {
			if(com.getNombre().equals(nombre)) {
				c=com;
			}
		}
		return c;
	}

}
