package proyectoGimnasia.model.DTO;

public class Persona {
	private String dni;
	private String nombre;
	private String correo;
	private int telefono;
	private int edad;
	
	public Persona() {
		this.dni="";
		this.nombre="";
		this.correo="";
		this.telefono=0;
	}

	public Persona(String dni, String nombre, String correo, int telefono, int edad) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
		this.edad = edad;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
		Persona other = (Persona) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
	    return " - DNI: " + dni + "\n"
	         + " - Nombre: " + nombre + "\n"
	         + " - Correo: " + correo + "\n"
	         + " - Telefono: " + telefono + "\n"
	    	 + " - Edad: "+ edad + "\n";
	}


}
