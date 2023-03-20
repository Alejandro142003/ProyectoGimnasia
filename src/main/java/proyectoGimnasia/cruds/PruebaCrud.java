package proyectoGimnasia.cruds;


import proyectoGimnasia.model.DTO.Categoria;
import proyectoGimnasia.model.DTO.Competicion;
import proyectoGimnasia.model.DTO.Prueba;
import proyectoGimnasia.model.DTO.Tipo;
import proyectoGimnasia.utils.Utils;
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
			List<Prueba> pruebas = c.getPruebas();       
			if(c.getNombre().equals(nombreComp)) {
				valid = c.getPruebas().contains(p);
				Tipo tipo = Utils.validTipo("Introduzca el nuevo tipo: ");
				p.setTipo(tipo);
				Categoria categoria = Utils.validCategoria("Introduzca la nueva categoría: ");
				p.setCategoria(categoria);
				Aparato aparato = Utils.validAparato("Introduzca el nuevo aparato: ");
				p.setAparato(aparato);
				rc.setCompeticiones(comps);
				rc.guardarXML(comps);
				valid=true;
			}
		}
		return valid;
	}
  

	public static void mostrarPrueba(String nombreComp, Prueba p) {
	    RepoCompeticiones rc = RepoCompeticiones.newInstance();
	    List<Competicion> comps = rc.getCompeticiones();
	    for (Competicion c : comps) {
	        if (c.getNombre().equalsIgnoreCase(nombreComp)) {
	            if (c.getPruebas().contains(p)) {
	               Utils.print("Tipo: "+p.getTipo());
	               Utils.print("Categoria: "+p.getCategoria());
	               Utils.print("Aparato: "+p.getAparato());
	     
	            } else {
	            	Utils.print("La prueba no se encontró en la competición.");
	            }
	        }
	      Utils.print("La competición no se encontró.");
	    }
	}

	
	public static void mostrarTodasLasPruebas() {     
    	RepoCompeticiones rc = RepoCompeticiones.newInstance();     
    	List<Competicion> comps = rc.getCompeticiones();     
    	for (Competicion c : comps) {         
    		List<Prueba> pruebas = c.getPruebas();         
    		for (Prueba p : pruebas) {             
    			System.out.println(p.toString());  
    		}
    	}
    }
	
	
	
}

