package proyectoGimnasia.model.DTO;

import java.util.ArrayList;


public class Prueba {
	private String tipo;
	private Categoria categoria;
	private Aparato aparato;
	private ArrayList<Participacion> participaciones;

	
	public Prueba() {
	    this.tipo = "";
	    this.categoria = null;
	    this.aparato = null;
	    this.participaciones = new ArrayList<Participacion>();
	}

	public Prueba(String tipo, Categoria categoria, Aparato aparato) {
	    super();
	    this.tipo = tipo;
	    this.categoria = categoria;
	    this.aparato = aparato;
	    this.participaciones = new ArrayList<Participacion>();
	}

	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Aparato getAparato() {
		return aparato;
	}
	
	public void setAparato(Aparato aparato) {
		this.aparato = aparato;
	}
	
	public ArrayList<Participacion> getParticipaciones() {
        return participaciones;
    }

    public void setParticipaciones(ArrayList<Participacion> participaciones) {
        this.participaciones = participaciones;
    }
	
	@Override
	public String toString() {
		return "Prueba [Tipo=" + tipo + ""
				+ "/n Categoria=" + categoria 
				+ "/n Aparato=" + aparato 
				+ "/n Participaciones=" + participaciones + "]";
	}
}
