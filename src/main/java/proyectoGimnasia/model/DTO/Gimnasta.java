package proyectoGimnasia.model.DTO;

public class Gimnasta extends Persona{
	
	private String categoria;
	private String club;
	private int dorsal;

	public Gimnasta() {
		super();
		this.categoria = "";
		this.club="";
		this.dorsal=0;
	}

	public Gimnasta(String dni, String nombre, String correo, int telefono, String categoria, String club,
			int dorsal) {
		super(dni, nombre, correo, telefono);
		this.categoria = categoria;
		this.club = club;
		this.dorsal = dorsal;
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

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + dorsal;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gimnasta other = (Gimnasta) obj;
		if (dorsal != other.dorsal)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Gimanasta [categoria=" + categoria + ", club=" + club + ", dorsal=" + dorsal + "]";
	}
	
}
