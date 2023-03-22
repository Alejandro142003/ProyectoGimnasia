package proyectoGimnasia.interfaces;

import java.util.List;

import proyectoGimnasia.model.DTO.Grupo;

public interface iRepoGrupo {
	public List<Grupo> getGrupos();
	public void setGrupos(List<Grupo> grupos);
	public boolean guardarXML(List<Grupo> grupos);
}
