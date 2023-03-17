package proyectoGimnasia.interfaces;

import java.util.List;

import proyectoGimnasia.model.DTO.Gimnasta;

public interface iRepoGimnasta {
	public List<Gimnasta> getGimnastas();
	public void setGimnastas(List<Gimnasta> gimnastas);
	public boolean guardarXML(List<Gimnasta> gimnastas);
}
