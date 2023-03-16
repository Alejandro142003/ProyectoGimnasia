package proyectoGimnasia.model;

import java.sql.Time;
import java.util.ArrayList;
import proyectoGimnasia.interfaces.iRepoParticipacion;
import proyectoGimnasia.model.DTO.Participacion;
import proyectoGimnasia.utils.Utils;

public class RepoParticipacion<T> implements iRepoParticipacion<T> {
	private ArrayList<Participacion<T>> participaciones = new ArrayList<Participacion<T>>();

	public boolean addParticipation(Participacion<T> newParticipacion) {
		boolean result=false;
		if(!participaciones.contains(newParticipacion) && newParticipacion.getDorsal()==null) {
			participaciones.add(newParticipacion);
			result=true;
		}
		return result;
	}
	
	public boolean editParticipation(int dorsal) {
		boolean result=false;
		if (participaciones.isEmpty()) {
			System.out.println("No hay participaciones para editar");
		} else {
			for(Participacion<T> part:participaciones) {
				if(part.getDorsal().equals(dorsal)) {
					part.setParticipantes((T) Utils.leeString("Itroduce el tipo de participante"));
					String horaString = Utils.leeString("Ingrese la hora de participación (en formato HH:mm:ss):");
					part.setHora(Time.valueOf(horaString));
					if (part.puedeSerPuntuado()) {
						part.setPuntuacion(Utils.getDouble("Itroduce la puntuacion de la participacion"));
					} else {
						System.out.println("El participante " + part.getDorsal() + " no puede ser puntuado aún.");
					}
					
					result= true;
				} else {
					System.out.println("No existe ninguna participacion con el dorsal "+"'"+dorsal+"'");
				}
			}
		}
		return result;
	}

	public boolean deleteParticipation(int dorsal) {
		boolean result=false;
		if (participaciones.isEmpty()) {
			System.out.println("No hay participaciones para borrar");
		} else {
			for(Participacion<T> part:participaciones) {
				if(part.getDorsal().equals(dorsal)) {
					participaciones.remove(part);
					result=true;	
				} else {
					System.out.println("No existe ninguna participacion con el dorsal "+"'"+dorsal+"'");
				}
			}
		}
		return result;
	}

	public Participacion<T> showParticipation(int dorsal) {
		Participacion<T> p = null;
		for(Participacion<T> part:participaciones) {
			if(part.getDorsal().equals(dorsal)) {
				p=part;
			} else {
				System.out.println("No existe ninguna participacion con el dorsal "+"'"+dorsal+"'");
			}
		}
		return p;
		
	}

}
