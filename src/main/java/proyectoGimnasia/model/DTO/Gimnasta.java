package proyectoGimnasia.model.DTO;

import java.io.Serializable;

public class Gimnasta extends Persona implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private String categoria;
	private String club;

	public Gimnasta() {
		super();
		this.categoria = "";
		this.club="";
	}

	public Gimnasta(String dni, String nombre, String correo, int telefono, String categoria, String club, int edad) {
		super(dni, nombre, correo, telefono, edad);
		this.categoria = categoria;
		this.club = club;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}


	@Override
	public String toString() {
	    return "Gimnasta:\n"
	    	 + super.toString()
	         + " - Categoria: " + categoria + "\n"
	         + " - Club: " + club + "\n";
	}
	
}
