package proyectoGimnasia.model.DTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Competicion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String descripcion;
	private LocalDate fechaInicio;
	private List<Prueba> pruebas;
	
	
	
	public Competicion() {
		this.nombre="";
		this.descripcion="";
		this.fechaInicio=null;
		
	}
	public Competicion(String nombre, String descripcion, LocalDate fechaInicio) {
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
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
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

	
	
	
}
