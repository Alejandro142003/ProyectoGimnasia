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
		RepoCompeticiones copia = XMLManager.readXML(new RepoCompeticiones(), "competicion.xml");
		System.out.println("CREANDO REPO");
		if(copia!=null) {
			System.out.println("REPO ENCONTRADO");
			this.competiciones = copia.getCompeticiones();
		}
		if(this.competiciones==null) {
			this.competiciones = new ArrayList<>();
		}
		System.out.println(copia);
	}
	
	private RepoCompeticiones() {
		this.competiciones = new ArrayList<>();
	}
	
	public static RepoCompeticiones newInstance() {
		if(_instance == null) _instance = new RepoCompeticiones(true);
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

	

}
