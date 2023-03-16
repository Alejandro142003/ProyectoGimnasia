package proyectoGimnasia.cruds;

import java.time.LocalDate;
import java.util.List;


import proyectoGimnasia.model.RepoCompeticiones;
import proyectoGimnasia.model.DTO.Competicion;

public class CompeticionCrud{
	
	
	public boolean addCompetition(Competicion c) {
		RepoCompeticiones rc = RepoCompeticiones.newInstance();
		List<Competicion> comp = rc.getCompeticiones();
		boolean result = comp.add(c);
		if(result) {
			rc.setCompeticiones(comp);
			rc.guardarXML(comp);
		}
		return result;
	}
	
	public Competicion findCompetition(String nombre) {
		RepoCompeticiones rc = RepoCompeticiones.newInstance();
		List<Competicion> comp = rc.getCompeticiones();
		Competicion co=null;
		for(Competicion c: comp) {
			if(c.getNombre()==nombre) {
				co=c;
			}
		}
		return co;
		
	}
	
	public boolean editCompetition(Competicion c) {
		RepoCompeticiones rc = RepoCompeticiones.newInstance();
		List<Competicion> comp = rc.getCompeticiones();
		boolean valid=false;
		for(Competicion co : comp) {
			if(co.getNombre()==c.getNombre()) {
				co.setDescripcion(c.getDescripcion());
				co.setFechaInicio(c.getFechaInicio());
				rc.setCompeticiones(comp);
				rc.guardarXML(comp);
				valid=true;
			}
		}
		return valid;

		
	}
	
	public boolean deleteCompetition(Competicion c) {
		RepoCompeticiones rc = RepoCompeticiones.newInstance();
		List<Competicion> comp = rc.getCompeticiones();
		boolean result = comp.remove(c);
		if(result) {
			rc.setCompeticiones(comp);
			rc.guardarXML(comp);
		}
		return result;
		
	}
	
	public String showAll() {
		RepoCompeticiones rc = RepoCompeticiones.newInstance();
		List<Competicion> comp = rc.getCompeticiones();
		String result = "";
		for(Competicion c: comp) {
			if(c!=null) {
				result+=c+"\n";
			}
		}
		return result;
	}
	
	
	
}
