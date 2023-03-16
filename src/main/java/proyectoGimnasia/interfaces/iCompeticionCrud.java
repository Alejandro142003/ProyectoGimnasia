package proyectoGimnasia.interfaces;

import proyectoGimnasia.model.DTO.Competicion;

public interface iCompeticionCrud {
	boolean addCompetition(Competicion c);
	Competicion findCompetition(String nombre);
	boolean deleteCompetition(Competicion c);
	String showAll();
}
