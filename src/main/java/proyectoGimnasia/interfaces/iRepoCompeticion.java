package proyectoGimnasia.interfaces;

import proyectoGimnasia.model.DTO.Competicion;

public interface iRepoCompeticion {
	boolean addCompetition(Competicion competicion);
	Competicion showCompetition(String nombre);
}
