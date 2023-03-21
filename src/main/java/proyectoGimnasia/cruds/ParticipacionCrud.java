package proyectoGimnasia.cruds;

import proyectoGimnasia.model.DTO.Categoria;
import proyectoGimnasia.model.DTO.Competicion;
import proyectoGimnasia.model.DTO.Tipo;
import proyectoGimnasia.model.DTO.Aparato;
import proyectoGimnasia.model.DTO.Participacion;
import proyectoGimnasia.model.DTO.Prueba;
import proyectoGimnasia.utils.Utils;
import proyectoGimnasia.model.RepoCompeticiones;

import java.util.ArrayList;
import java.util.List;

public class ParticipacionCrud<T> {

    public static <T> boolean agregaParticipacion(String nombreComp,Prueba p1, Participacion<T> p) {
        boolean result = false;
        RepoCompeticiones rc = RepoCompeticiones.newInstance();
        List<Competicion> comps = rc.getCompeticiones();
        for (Competicion c : comps) {
            if (c.getNombre().equalsIgnoreCase(nombreComp)) {
            	if(c.getPruebas().contains(p1)) {
            		result = p1.getParticipaciones().add(p);
				}	
                break;
            }
        }
        if (result) {
            rc.guardarXML(comps);
        }
        return result;
    }

    public static <T> boolean eliminaParticipacion(String nombreComp, Prueba p1, Participacion<T> p) {
        boolean result = false;
        RepoCompeticiones rc = RepoCompeticiones.newInstance();
        List<Competicion> comps = rc.getCompeticiones();
        for (Competicion c : comps) {
            if (c.getNombre().equals(nombreComp)) {
            	if(c.getPruebas().contains(p1)) {
            		result = p1.getParticipaciones().remove(p);
            	}
                break;
            }
        }
        if (result) {
            rc.guardarXML(comps);
        }
        return result;
    }

    public static <T> boolean editarParticipacion(String nombreComp, Participacion<T> p, Participacion<T> pnueva, Prueba p1) {
        boolean valid = false;
        RepoCompeticiones rc = RepoCompeticiones.newInstance();
        List<Competicion> comps = rc.getCompeticiones();
        for (Competicion c : comps) {
            if (c.getNombre().equals(nombreComp)) {
                ArrayList<Participacion<T>> participaciones = p1.getParticipaciones();
                if (c.getPruebas().contains(p1) && !p1.getParticipaciones().contains(pnueva) && c.getPruebas().contains(p)) {
                    Participacion<T> pfound = participaciones.get(participaciones.lastIndexOf(p));
                    pfound.setParticipantes(pnueva.getParticipantes());
                    pfound.setHora(pnueva.getHora());
                    pfound.setPuntuacion(pnueva.getPuntuacion());
                    rc.setCompeticiones(comps);
                    rc.guardarXML(comps);
                    valid = true;
                }

            }
        }
        return valid;
    }

    public static <T> void mostrarParticipacion(String nombreComp, Prueba p1, Participacion<T> p) {
    	RepoCompeticiones rc = RepoCompeticiones.newInstance();
        List<Competicion> comps = rc.getCompeticiones();
        for (Competicion c : comps) {
            if (c.getNombre().equalsIgnoreCase(nombreComp)) {
                if (c.getPruebas().contains(p1)) {
                	if (p1.getParticipaciones().contains(p)) {
	                    Utils.print("Tipo: " + p.getParticipantes());
	                    Utils.print("Hora: " + p.getHora());
	                    Utils.print("Puntuación: " + p.getPuntuacion());
                	} else {
                		Utils.print("La participación no se encontró en la competición.");
                }
                return;
            }
        }
            Utils.print("La competición no se encontró.");
        }
    }

    public static <T> void mostrarTodasLasParticipaciones() {
    	RepoCompeticiones rc = RepoCompeticiones.newInstance();
        List<Competicion> comps = rc.getCompeticiones();
        for (Competicion c : comps) {
            Utils.print("Competición: " + c.getNombre());
            for (Prueba prueba : c.getPruebas()) {
                Utils.print("\tPrueba: " + prueba.getTipo() + " - " + prueba.getCategoria() + " - " + prueba.getAparato());
                for (Participacion<T> participacion : prueba.getParticipaciones()) {
                    Utils.print("\t\tParticipante: " + participacion.getParticipantes() + " - Hora: " + participacion.getHora() + " - Puntuación: " + participacion.getPuntuacion());
                }
            }
        }
    }
}
