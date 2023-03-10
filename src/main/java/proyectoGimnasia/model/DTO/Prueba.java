package proyectoGimnasia.model.DTO;

import java.util.ArrayList;

public class Prueba {
	private String tipo;
	private String categoria;
	private String aparato;
	private ArrayList<String> participacion;
	
	public Prueba() {
		this.tipo="";
		this.categoria="";
		this.aparato="";
		this.participacion=null;
	}
	public Prueba(String tipo, String categoria, String aparato) {
		super();
		this.tipo = tipo;
		this.categoria = categoria;
		this.aparato = aparato;
		this.participacion = participacion;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getAparato() {
		return aparato;
	}
	public void setAparato(String aparato) {
		this.aparato = aparato;
	}
	public ArrayList<String> getParticipacion() {
        return participacion;
    }

    public void setParticipacion(ArrayList<String> participacion) {
        this.participacion = participacion;
    }
	@Override
	public String toString() {
		return "Prueba [tipo=" + tipo + ", categoria=" + categoria + ", aparato=" + aparato + ", participacion="
				+ participacion + "]";
	}
	
	
	
	
}