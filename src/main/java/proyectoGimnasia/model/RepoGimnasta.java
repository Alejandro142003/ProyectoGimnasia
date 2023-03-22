package proyectoGimnasia.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import proyectoGimnasia.interfaces.iRepoGimnastaGrupo;
import proyectoGimnasia.model.DTO.Gimnasta;
import proyectoGimnasia.model.DTO.Grupo;
import proyectoGimnasia.utils.XMLManager;

@XmlRootElement(name="ProyectoGestionCompeticionesGimnasia")
@XmlAccessorType(XmlAccessType.FIELD)
public class RepoGimnasta implements iRepoGimnastaGrupo ,Serializable{
	
	@XmlTransient
	private static final long serialVersionUID = 1L;
	@XmlTransient
	private static RepoGimnasta _instance;
	
	private List<Gimnasta> gimnastas;
	private List<Grupo> grupos;
	
	private RepoGimnasta(boolean fake) {
		RepoGimnasta copia = XMLManager.readXML(new RepoGimnasta(), "gimnasta.xml");
		if(copia!=null) {
			this.gimnastas = copia.getGimnastas();
		}
		if(this.gimnastas==null) {
			this.gimnastas = new ArrayList<>();
		}
	}
	
	private RepoGimnasta() {
		this.gimnastas= new ArrayList<>();
	}
	
	public static RepoGimnasta newInstance() {
		if(_instance == null) _instance = new RepoGimnasta(true);
			return _instance;
	}
		
	public List<Gimnasta> getGimnastas() {
		return gimnastas;
	}

	public void setGimnastas(List<Gimnasta> gimnastas) {
		this.gimnastas = gimnastas;
	}
	
	public List<Grupo> getGrupos() {
		return grupos;
	}
	
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	
	public boolean guardarXMLGimnasta(List<Gimnasta> gimnastas) {
		return XMLManager.writeXML(this, "gimnasta.xml");
	}
	
	public boolean guardarXMLGrupo(List<Grupo> grupos) {
		return XMLManager.writeXML(this, "gimnasta.xml");
	}
}
