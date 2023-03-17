package proyectoGimnasia.cruds;

import proyectoGimnasia.interfaces.iRepoPrueba;
import proyectoGimnasia.model.DTO.Categoria;
import proyectoGimnasia.model.DTO.Competicion;
import proyectoGimnasia.model.DTO.Prueba;
import proyectoGimnasia.model.DTO.Aparato;
import proyectoGimnasia.model.RepoCompeticiones;
import proyectoGimnasia.model.RepoPrueba;

import java.util.List;

public class PruebaCrud {
  



	public static boolean agregaPrueba(String nombreComp,Prueba p) {
        boolean result = false;
        RepoCompeticiones rc=RepoCompeticiones.newInstance();
        List<Competicion> comps = rc.getCompeticiones();
        for(Competicion c : comps) {
            if(c.getNombre().equalsIgnoreCase(nombreComp)) {
                result = c.getPruebas().add(p);
                break;
            }
        }
        if(result) {
            rc.guardarXML(comps);
        }
        return result;
    }
	
	public boolean eliminaPrueba(String nombreComp, Prueba p) {
		boolean result = false;
		RepoCompeticiones rc= RepoCompeticiones.newInstance();
		List<Competicion> comps = rc.getCompeticiones();
		for(Competicion c: comps) {
			if(c.getNombre().equals(nombreComp)) {
				result = c.getPruebas().remove(p);
				break;
			}
		}
		if(result) {
			rc.guardarXML(comps);
		}
		return result;
		
	}
	
	public boolean editarPrueba (String nombreComp, Prueba p) {
		boolean valid = false;
		RepoCompeticiones rc= RepoCompeticiones.newInstance();
		List<Competicion> comps = rc.getCompeticiones();
		for(Competicion c: comps) {
			if(c.getNombre().equals(nombreComp)) {
				valid = c.getPruebas().equals(p);
				p.setTipo(p.getTipo());
				p.setCategoria(p.getCategoria());
				p.setAparato(p.getAparato());
				rc.setCompeticiones(comps);
				rc.guardarXML(comps);
				valid=true;
			}
		}
		return valid;
	}
  
	public boolean mostrarPrueba (String nombreComp, Prueba p) {
		boolean result = false;
		RepoCompeticiones rc= RepoCompeticiones.newInstance();
		RepoPrueba rp = RepoPrueba.newInstance();
		List<Competicion> comps = rc.getCompeticiones();
		for(Competicion c: comps) {
			if(c.getNombre().equals(nombreComp)) {
				rp.getPruebas().equals(p);
				rc.setCompeticiones(comps);
				rc.guardarXML(comps);
				result=true;
			}
		}
		
		return result;
		}
}

