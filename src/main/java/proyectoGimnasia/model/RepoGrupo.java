package proyectoGimnasia.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import proyectoGimnasia.interfaces.iRepoGimnasta;
import proyectoGimnasia.interfaces.iRepoGrupo;
import proyectoGimnasia.model.DTO.Gimnasta;
import proyectoGimnasia.model.DTO.Grupo;
import proyectoGimnasia.utils.Utils;
import proyectoGimnasia.utils.XMLManager;

@XmlRootElement(name="ProyectoGestionCompeticionesGimnasia")
@XmlAccessorType(XmlAccessType.FIELD)
public class RepoGrupo implements iRepoGrupo ,Serializable{
	
	@XmlTransient
	private static final long serialVersionUID = 1L;
	@XmlTransient
	private static RepoGrupo _instance;
	
	private List<Grupo> grupos;
	
	private RepoGrupo(boolean fake) {
		RepoGrupo copia = XMLManager.readXML(new RepoGrupo(), "gimnasta.xml");
		if(copia!=null) {
			this.grupos = copia.getGrupos();
		}
		if(this.grupos==null) {
			this.grupos = new ArrayList<>();
		}
	}
	
	private RepoGrupo() {
		this.grupos= new ArrayList<>();
	}
	
	public static RepoGrupo newInstance() {
		if(_instance == null) _instance = new RepoGrupo(true);
			return _instance;
	}
	
	public List<Grupo> getGrupos() {
		return grupos;
	}
	
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	
	public boolean guardarXML(List<Grupo> grupos) {
		return XMLManager.writeXML(this, "gimnasta.xml");
	}

}
