package proyectoGimnasia.model.DTO;

import java.sql.Time;	//Preguntar en clase 

public class Participacion<T> {
    private T participantes;
    private Time hora;
    private double puntuacion;
    
    public Participacion(T participantes, Time hora, double puntuacion) {
        this.participantes = participantes;
        this.hora = hora;
        this.puntuacion = puntuacion;
    }
    
    public Participacion() {
    	this.participantes = null;
    	this.hora = null;
    	this.puntuacion = 0.0;
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
}