package proyectoGimnasia.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import proyectoGimnasia.interfaces.iRepoCompeticion;
import proyectoGimnasia.model.DTO.Competicion;
import proyectoGimnasia.utils.XMLManager;
@XmlRootElement(name="ProyectoGestionCompeticionesGimnasia")
@XmlAccessorType(XmlAccessType.FIELD)
public class RepoCompeticiones implements iRepoCompeticion ,Serializable{
	
	
	@XmlTransient
	private static final long serialVersionUID = 1L;
	@XmlTransient
	private static RepoCompeticiones _instance;
	
	
	private List<Competicion> competiciones;
	
	private RepoCompeticiones(boolean fake) {
		
	}
	
	
	private RepoCompeticiones() {
		RepoCompeticiones copia = XMLManager.readXML(new RepoCompeticiones(true), "competicion.xml");
		if(copia!=null) {
			this.competiciones = copia.getCompeticiones();
		}
		if(this.competiciones==null) {
			this.competiciones = new ArrayList<>();
		}
	}
	
	public static RepoCompeticiones newInstance() {
		if(_instance == null) _instance = new RepoCompeticiones();
			return _instance;
	}
	
	
	public List<Competicion> getCompeticiones() {
		return competiciones;
	}


	public void setCompeticiones(List<Competicion> competiciones) {
		this.competiciones = competiciones;
	}

	public boolean guardarXML(List<Competicion> competiciones) {
		return XMLManager.writeXML(this, "competicion.xml");
	}

	public boolean addCompetition(Competicion competicion) {
		boolean result=false;
		if(!competiciones.contains(competicion)) {
			competiciones.add(competicion);
			result=true;
		}
		return result;
	}

	
	public String showAllCompetitions() {
		String result="";
		for(Competicion c: competiciones) {
			if(c!=null) {
				result+=c+"\n";
			}
		}
		return result;
	}
	

	public Competicion showCompetition(String nombre) {
		Competicion c = null;
		for(Competicion com:competiciones) {
			if(com.getNombre().equals(nombre)) {
				c=com;
			}
		}
		return c;
	}

}
