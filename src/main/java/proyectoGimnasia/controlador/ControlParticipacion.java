package proyectoGimnasia.controlador;

import java.sql.Time;

import proyectoGimnasia.cruds.ParticipacionCrud;
import proyectoGimnasia.interfaces.iControllerParticipacion;
import proyectoGimnasia.interfaces.iGUIParticipacion;
import proyectoGimnasia.model.DTO.Aparato;
import proyectoGimnasia.model.DTO.Categoria;
import proyectoGimnasia.model.DTO.Participacion;
import proyectoGimnasia.model.DTO.Prueba;
import proyectoGimnasia.model.DTO.Tipo;
import proyectoGimnasia.utils.Utils;
import proyectoGimnasia.vistas.ParticipacionView;

public class ControlParticipacion<T> implements iControllerParticipacion {
	private ParticipacionCrud partCrud =new ParticipacionCrud();
	private iGUIParticipacion partgui = new ParticipacionView();
	private ControlPrincipal parent;
	public ControlParticipacion(ControlPrincipal parent) {
		this.parent = parent;
	}
	
	
	public void controlPartitionMenu(int op) {
		int option;
		boolean valid = false;
		
		do {
			partgui.showParticipationMenu();
			option=Utils.leeEntero("Elije la opcion: ");
			switch(option) {
				case 5:
					valid=true;
					Utils.print("Has salido correctamente del menu participacion.");
					break;
				case 1:
					controllerAddParticipation();
					break;
				case 2:
					controllerEditParticipation();
					break;
				case 3:
					contollerShowParticipation();
					break;
				case 4:
					controllerDeleteParticipation();
					break;
				default:
					Utils.print("Opción incorrecta");
					break;
			}
		}while(!valid);
			
	}

	public void controllerAddParticipation() {
        String nombreComp = Utils.leeString("Itroduce el nombre de la competicion");
        Tipo p = Utils.validTipo("Itroduce el tipo de la prueba");
        Categoria categoria = Utils.validCategoria("Introduce la categoría: ");
        Aparato aparato = Utils.validAparato("Introduce el aparato: ");
        Prueba prueba = new Prueba(p, categoria, aparato);
        T tipo = (T) Utils.leeString("Ingrese el tipo de participante:"); // asumiendo que el tipo se ingresa como una cadena
        String horaString = Utils.leeString("Ingrese la hora de participación (en formato HH:mm:ss):");
        Time hora = Time.valueOf(horaString);
        double puntuacion = 0;
        Integer dorsal = Utils.leeEntero("Ingrese el número dorsal:");
      
        Participacion<T> newParticipacion = new Participacion<T>(tipo, hora, puntuacion, dorsal);
        
        if(partCrud.agregaParticipacion(nombreComp, prueba, newParticipacion)) {
			Utils.print("Se ha introducido correctamente la participacion.");
		}else {
			Utils.print("No se ha introducido la participacion.");
		}
    }

	public void controllerEditParticipation() {
		String nombreComp = Utils.leeString("Itroduce el nombre de la competicion");
        Tipo p = Utils.validTipo("Itroduce el tipo de la prieba");
        Categoria categoria = Utils.validCategoria("Introduce la categoría: ");
        Aparato aparato = Utils.validAparato("Introduce el aparato: ");
        Prueba prueba = new Prueba(p, categoria, aparato);
        T tipo = (T) Utils.leeString("Ingrese el tipo de participante:"); // asumiendo que el tipo se ingresa como una cadena
        String horaString = Utils.leeString("Ingrese la hora de participación (en formato HH:mm:ss):");
        Time hora = Time.valueOf(horaString);
        double puntuacion = 0;
        Integer dorsal = Utils.leeEntero("Ingrese el número dorsal:");
        Participacion<T> oldParticipacion = new Participacion<T>(tipo, hora, puntuacion, dorsal);
        Participacion<T> newParticipacion = new Participacion<T>(tipo, hora, puntuacion, dorsal);
		partCrud.editaParticipacion(nombreComp, prueba, oldParticipacion, newParticipacion);
		
		if(partCrud.editaParticipacion(nombreComp, prueba, oldParticipacion, newParticipacion)) {
			Utils.print("Se ha editado correctamente la participacion.");
		}else {
			Utils.print("No se ha editado la participacion.");
		}
	}

	public void contollerShowParticipation() {
		String nombreComp = Utils.leeString("Itroduce el nombre de la competicion");
        Tipo p = Utils.validTipo("Itroduce el tipo de la prieba");
        Categoria categoria = Utils.validCategoria("Introduce la categoría: ");
        Aparato aparato = Utils.validAparato("Introduce el aparato: ");
        Prueba prueba = new Prueba(p, categoria, aparato);
        T tipo = (T) Utils.leeString("Ingrese el tipo de participante:"); // asumiendo que el tipo se ingresa como una cadena
        String horaString = Utils.leeString("Ingrese la hora de participación (en formato HH:mm:ss):");
        Time hora = Time.valueOf(horaString);
        double puntuacion = 0;
        Integer dorsal = Utils.leeEntero("Ingrese el número dorsal:");
        Participacion<T> Participacion = new Participacion<T>(tipo, hora, puntuacion, dorsal);
		partCrud.mostrarParticipacion(nombreComp, prueba, Participacion);
	}

	public void controllerDeleteParticipation() {
		String nombreComp = Utils.leeString("Itroduce el nombre de la competicion");
        Tipo p = Utils.validTipo("Itroduce el tipo de la prieba");
        Categoria categoria = Utils.validCategoria("Introduce la categoría: ");
        Aparato aparato = Utils.validAparato("Introduce el aparato: ");
        Prueba prueba = new Prueba(p, categoria, aparato);
        T tipo = (T) Utils.leeString("Ingrese el tipo de participante:"); // asumiendo que el tipo se ingresa como una cadena
        String horaString = Utils.leeString("Ingrese la hora de participación (en formato HH:mm:ss):");
        Time hora = Time.valueOf(horaString);
        double puntuacion = 0;
        Integer dorsal = Utils.leeEntero("Ingrese el número dorsal:");
        Participacion<T> oldParticipacion = new Participacion<T>(tipo, hora, puntuacion, dorsal);
		partCrud.eliminaParticipacion(nombreComp, prueba, oldParticipacion);
		
		if(partCrud.eliminaParticipacion(nombreComp, prueba, oldParticipacion)) {
			Utils.print("Se ha eliminado correctamente la participacion.");
		}else {
			Utils.print("No se ha eliminado la participacion.");
		}
	}
}
