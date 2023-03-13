package proyectoGimnasia.interfaces;

import proyectoGimnasia.model.DTO.Participacion;

public interface iRepoParticipacion<T> {
	boolean addParticipation(Participacion<T> newParticipacion);
	boolean editParticipation(int dorsal);
	boolean deleteParticipation(int dorsal);
	Participacion<T> showParticipation(int dorsal);
}
