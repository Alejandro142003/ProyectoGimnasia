package proyectoGimnasia.model.DTO;

import java.sql.Time;	//Preguntar en clase 

public class Participacion<T> {
    private T participantes;
    private Time hora;
    private double puntuacion;
    private Integer dorsal;
    
	public Participacion(T participantes, Time hora, double puntuacion, Integer dorsal) {
        this.participantes = participantes;
        this.hora = hora;
        this.puntuacion = puntuacion;
        this.dorsal = dorsal;
    }
    
    public Participacion() {
    	this.participantes = null;
    	this.hora = null;
    	this.puntuacion = 0.0;
    	this.dorsal = null;
    }
    
    // Getters y setters para los atributos de la clase
    public T getParticipantes() {
        return participantes;
    }
    
    public void setParticipantes(T participantes) {
        this.participantes = participantes;
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
}