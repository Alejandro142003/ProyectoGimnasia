package proyectoGimnasia.interfaces;

import java.util.List;

import proyectoGimnasia.model.DTO.Gimnasta;
import proyectoGimnasia.model.DTO.Grupo;

public interface iRepoGimnastaGrupo {
	public List<Gimnasta> getGimnastas();
	public void setGimnastas(List<Gimnasta> gimnastas);
	public boolean guardarXMLGimnasta(List<Gimnasta> gimnastas);
	public boolean guardarXMLGrupo(List<Grupo> grupos);
}
