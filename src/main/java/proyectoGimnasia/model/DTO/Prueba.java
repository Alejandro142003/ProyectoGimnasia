package proyectoGimnasia.model.DTO;

import java.util.ArrayList;

public class Prueba {
	private String tipo;
	private String categoria;
	private String aparato;
	ArrayList<Participacion> clase = new ArrayList<Participacion>(); //mirar por que cre que solo son los participantes
	
	public Prueba() {
		this.tipo="";
		this.categoria="";
		this.aparato="";
	}
	public Prueba(String tipo, String categoria, String aparato) {
		super();
		this.tipo = tipo;
		this.categoria = categoria;
		this.aparato = aparato;
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
	
	@Override
	public String toString() {
		return "Prueba [tipo=" + tipo + ", categoria=" + categoria + ", aparato=" + aparato + "]";
	}
	
	
}
