package proyectoGimnasia.model.DTO;

import java.io.Serializable;
import java.sql.Time;
import java.util.Calendar;

public class Participacion<T> implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private T tipo;
    private Time hora;
    private double puntuacion;
    private Integer dorsal;//Para indicar dorsal
    
	public Participacion(T tipo, Time hora, double puntuacion, Integer dorsal) {
        this.tipo = tipo;
        this.hora = hora;
        this.puntuacion = puntuacion;
        this.dorsal = dorsal;
    }
    
    public Participacion() {
    	this.tipo = null;
    	this.hora = null;
    	this.puntuacion = 0.0;
    	this.dorsal = null;
    }
    
    // Getters y setters para los atributos de la clase
    public T getParticipantes() {
        return tipo;
    }
    
    public void setParticipantes(T tipo) {
        this.tipo = tipo;
    }
    
    public Time getHora() {
        return hora;
    }
    
    public void setHora(Time hora) {
        this.hora = hora;
    }
    
    public double getPuntuacion() {
        return puntuacion;
    }
    
    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }
    
    /**
	 * @return the dorsal
	 */
	public Integer getDorsal() {
		return dorsal;
	}

	/**
	 * @param dorsal the dorsal to set
	 */
	public void setDorsal(Integer dorsal) {
		this.dorsal = dorsal;
	}
	
	/**
	 * Metodo que comprueba si puede ser puntuado o no
	 * @return boolean con true si puede o false si no puede
	 */
	 public boolean puedeSerPuntuado() {
	        Calendar calendar = Calendar.getInstance();
	        Time horaActual = new Time(calendar.getTimeInMillis());
	        return hora.before(horaActual) || hora.equals(horaActual);
	    }

	@Override
	public String toString() {
	    return "Participacion:\n"
	         + " - Tipo: " + tipo + "\n"
	         + " - Hora: " + hora + "\n"
	         + " - Puntuacion: " + puntuacion + "\n"
	         + " - Dorsal: " + dorsal + "\n";
	}

	
}