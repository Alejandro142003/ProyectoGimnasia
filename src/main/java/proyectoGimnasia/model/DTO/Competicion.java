package proyectoGimnasia.model.DTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Competicion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String descripcion;
	private Date fechaInicio;
	private List<Prueba> pruebas;
	
	
	
	public Competicion() {
		this.nombre="";
		this.descripcion="";
		this.fechaInicio=null;
		
	}
	public Competicion(String nombre, String descripcion, Date fechaInicio) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		pruebas =new ArrayList<Prueba>();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public List<Prueba> getPruebas() {
		return pruebas;
	}
	public void setPruebas(List<Prueba> pruebas) {
		this.pruebas = pruebas;
	}
	
	@Override
	public String toString() {
	    return "Competicion:\n"
	         + " - Nombre: " + nombre + "\n"
	         + " - Descripcion: " + descripcion + "\n"
	         + " - Fecha de inicio: " + fechaInicio + "\n"
	         + " - Pruebas: " + pruebas + "\n";
	}
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Competicion other = (Competicion) obj;
		return Objects.equals(nombre, other.nombre);
	}

	
	
	
}
