package proyectoGimnasia.cruds;

import java.time.LocalDate;
import java.util.List;


import proyectoGimnasia.model.RepoCompeticiones;
import proyectoGimnasia.model.DTO.Competicion;
import proyectoGimnasia.utils.Utils;

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
			if(c.getNombre().equals(nombre)) {
				co=c;
				break;
			}else {
				Utils.print("No se ha encontrado la competicion.");
			}
		}
		return co;
		
	}
	
	public void editCompetition() {
		RepoCompeticiones rc = RepoCompeticiones.newInstance();
		List<Competicion> comp = rc.getCompeticiones();
		showAll();
		if(comp.isEmpty()) {
			Utils.print("No ha competiciones para editar.");
		}else {
			String nombre = Utils.leeString("Introduce el nombre de la competicion: ");
			for(Competicion co : comp) {
				if(co.getNombre()==co.getNombre()) {
					String descripcion = Utils.leeString("Introduce la nueva descripcion");
					co.setDescripcion(descripcion);
					LocalDate fechaInicio = LocalDate.now();
					co.setFechaInicio(fechaInicio);
					rc.setCompeticiones(comp);
					rc.guardarXML(comp);
				}
			}
		}

		
	}
	
	public boolean deleteCompetition(Competicion c) {
		RepoCompeticiones rc = RepoCompeticiones.newInstance();
		List<Competicion> comp = rc.getCompeticiones();
		boolean result = comp.remove(c);
		if(result) {
			rc.setCompeticiones(comp);
			rc.guardarXML(comp);
			Utils.print("Se ha eliminado correctamente.");
		}else {
			Utils.print("No se ha eliminado correctamente.");
		}
		return result;
		
	}
	
	public String showAll() {
		RepoCompeticiones rc = RepoCompeticiones.newInstance();
		List<Competicion> comp = rc.getCompeticiones();
		String result = "";
		for(Competicion c: comp) {
			if(comp.isEmpty()) {
					Utils.print("No hay competiciones registradas");
			}else {
				if(c!=null) {
					result+=c+"\n";
				}
			}
		}
		return result;
	}
	
	
	
}
