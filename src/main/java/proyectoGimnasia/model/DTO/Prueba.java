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
        return "Prueba:\n"
             + " - Tipo: " + tipo + "\n"
             + " - Categoría: " + categoria + "\n"
             + " - Aparato: " + aparato + "\n";
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aparato == null) ? 0 : aparato.hashCode());
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prueba other = (Prueba) obj;
		if (aparato != other.aparato)
			return false;
		if (categoria != other.categoria)
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
    

}
