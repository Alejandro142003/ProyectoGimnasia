package proyectoGimnasia.cruds;

import java.sql.Time;
import java.util.List;

import proyectoGimnasia.model.RepoCompeticiones;
import proyectoGimnasia.model.RepoParticipacion;
import proyectoGimnasia.model.DTO.Competicion;
import proyectoGimnasia.model.DTO.Participacion;
import proyectoGimnasia.utils.Utils;

public class ParticipacionCrud {
    
	public <T> boolean addParticipacion(Participacion<T> p) {
		RepoCompeticiones rp = RepoCompeticiones.newInstance();
		List<Competicion> part = rp.getCompeticiones();
		boolean result= part.;
		if (result) {
			rp.setParticipaciones(part);
			rp.guardarXML(part);
		}
		return result;

	}

	public <T> void editParticipation() {
		RepoParticipacion<T> rp = RepoParticipacion.newInstance();
		List<Participacion<T>> part = rp.getParticipaciones();
		showAllGymnasts();
		if (part.isEmpty()) {
			Utils.print("No hay Participaciones para editar.");
		}else {
			int dorsal = Utils.leeEntero("Introduce el dorsal de la participacion que desea modificar: ");
			for (Participacion<T> p:part) {
				if (p.getDorsal() == dorsal) {
					T tipo = (T) Utils.leeString("Introduce el tipo: ");
					p.setParticipantes(tipo);
					String horaString = Utils.leeString("Ingrese la hora de participación (en formato HH:mm:ss):");
					p.setHora(Time.valueOf(horaString));
					double puntuacion = Utils.getDouble("Itroduce la puntuacion de la participacion");
					p.setPuntuacion(puntuacion);
					rp.setParticipaciones(part);
					rp.guardarXML(part);
				}
			}
		}
	}

	public <T> void deleteParticipacion() {
		showAllGymnasts();
		boolean result=false;
		RepoParticipacion<T> rp = RepoParticipacion.newInstance();
		List<Participacion<T>> part = rp.getParticipaciones();
		if (part.isEmpty()) {
			System.out.println("No hay participaciones para borrar");
		} else {
			for(Participacion<T> participacion:part) {
				if(participacion.getDorsal().equals(dorsal)) {
					part.remove(part);
					result=true;	
				} else {
					System.out.println("No existe ninguna participacion con el dorsal "+"'"+dorsal+"'");
				}
			}
		}
	}

	public <T> Participacion<T> showGymnast(int dorsal) {
		RepoParticipacion<T> rp = RepoParticipacion.newInstance();
		List<Participacion<T>> part = rp.getParticipaciones();
		Participacion<T> p = null;
		for(Participacion<T> participacion:part) {
			if(participacion.getDorsal() == dorsal) {
				p=participacion;
				break;
			} else {
				Utils.print("No existe ningun participante con el siguiente dorsal "+dorsal);
			}
		}
		return p;
	}

	public <T> String showAllGymnasts() {
		RepoParticipacion<T> rp = RepoParticipacion.newInstance();
		List<Participacion<T>> part = rp.getParticipaciones();
		String result ="";
		for (Participacion<T> participacion:part) {
			if (part.isEmpty()) {
				Utils.print("No existe ninguna participacion para mostrar");//Quizas haya que cambiarlo por return+="";
			} else {
				if (participacion !=null ) {
					result+=participacion+"\n";
				}else {
					result+="\n";
				}
			}
		}
		return result;
	}
}
