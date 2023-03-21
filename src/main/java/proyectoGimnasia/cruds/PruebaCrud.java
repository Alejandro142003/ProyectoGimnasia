package proyectoGimnasia.cruds;


import proyectoGimnasia.model.DTO.Categoria;
import proyectoGimnasia.model.DTO.Competicion;
import proyectoGimnasia.model.DTO.Prueba;
import proyectoGimnasia.model.DTO.Tipo;
import proyectoGimnasia.utils.Utils;
import proyectoGimnasia.model.DTO.Aparato;
import proyectoGimnasia.model.RepoCompeticiones;
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
	
	public boolean editarPrueba (String nombreComp, Prueba p, Prueba pnueva) {
		boolean valid = false;
		RepoCompeticiones rc= RepoCompeticiones.newInstance();
		List<Competicion> comps = rc.getCompeticiones();
		for(Competicion c: comps) {
			if(c.getNombre().equals(nombreComp)) {
				List<Prueba> pruebas = c.getPruebas();  
				if(c.getPruebas().contains(p) && !c.getPruebas().contains(pnueva)) {
					Prueba pfound = pruebas.get(pruebas.lastIndexOf(p));
					pfound.setAparato(pnueva.getAparato());
					pfound.setTipo(pnueva.getTipo());
					pfound.setCategoria(pnueva.getCategoria());
					rc.setCompeticiones(comps);
					rc.guardarXML(comps);
					valid=true;
				}
				
			}
		}
		return valid;
	}
  

	public Prueba mostrarPrueba(String nombreComp, Prueba p) {
	    RepoCompeticiones rc = RepoCompeticiones.newInstance();
	    List<Competicion> comps = rc.getCompeticiones();
	    Prueba p1 = null;
	    for (Competicion c : comps) {
	        if (c.getNombre().equalsIgnoreCase(nombreComp)) {
	        	List<Prueba> pruebas = c.getPruebas();  
	            if (c.getPruebas().contains(p)) {
	               p1=p;
	            } else {
	            	Utils.print("La prueba no se encontró en la competición.");
	            }
	        }    
	
	    }
	    return p1;
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

