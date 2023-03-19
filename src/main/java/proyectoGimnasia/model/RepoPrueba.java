package proyectoGimnasia.model;

import proyectoGimnasia.interfaces.iRepoPrueba;
import proyectoGimnasia.model.DTO.Aparato;
import proyectoGimnasia.model.DTO.Categoria;
import proyectoGimnasia.model.DTO.Prueba;
import proyectoGimnasia.utils.XMLManager;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
@XmlRootElement(name="ProyectoGestionCompeticionesGimnasia")
@XmlAccessorType(XmlAccessType.FIELD)

public class RepoPrueba implements iRepoPrueba, Serializable {
   
	@XmlTransient
	private static final long serialVersionUID = 1L;
	@XmlTransient
    private static RepoPrueba _instance;

    
    private List<Prueba> pruebas;
    

	public static RepoPrueba newInstance() {
		if(_instance == null) _instance = new RepoPrueba();
			return _instance;
	}
    
	public void setPruebas(List<Prueba> pruebas) {
		this.pruebas = pruebas;
	}
	
	public boolean guardarXML(List<Prueba> pruebas) {
		return XMLManager.writeXML(this, "prueba.xml");
	}
	
	@Override
    public List<Prueba> getPruebas() {
        return pruebas;
    }
  
	@Override
    public boolean addPrueba (Prueba p) {
    	boolean result=false;
    	if(!pruebas.contains(p)) {
    		pruebas.add(p);
    		result=true;
    	}
    	
    	return result;
    }
	
	
	@Override
    public Prueba showPrueba(String tipo, Categoria categoria, Aparato aparato) {
    	Prueba p = null;
    	for(Prueba pEncontrada: pruebas) {
    		if(pEncontrada.getTipo().equals(tipo)&&pEncontrada.getCategoria().equals(categoria)&&pEncontrada.getAparato().equals(aparato)) {
    			p=pEncontrada;
    		}
    	}
    	return p;
    }

	
	@Override
    public String showAllPruebas() {
    	String result="";
    	for(Prueba p: pruebas) {
    		if (p!=null) {
    			result+=p+"\n";
    		}
    	}
    	return result;
    }
    
	public boolean deletePrueba(Prueba p) {
		boolean result=false;
    	if(!pruebas.contains(p)) {
    		pruebas.remove(p);
    		result=true;
    	}
    	
    	return result;
	}
	
	


}


