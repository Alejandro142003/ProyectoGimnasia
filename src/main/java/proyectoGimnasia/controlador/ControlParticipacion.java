package proyectoGimnasia.controlador;

import java.sql.Time;

import proyectoGimnasia.interfaces.iControllerParticipacion;
import proyectoGimnasia.interfaces.iRepoParticipacion;
import proyectoGimnasia.model.RepoParticipacion;
import proyectoGimnasia.model.DTO.Participacion;
import proyectoGimnasia.utils.Utils;

public class ControlParticipacion<T> implements iControllerParticipacion {
	private iRepoParticipacion<T> repoParti = new RepoParticipacion<T>();

	
	private ControlPrincipal parent;
	public ControlParticipacion(ControlPrincipal parent) {
		this.parent = parent;
	}
	
	
	public void controlPartitionMenu(int op) {
		int option;
		boolean valid = false;
	
		do {
			
			option=Utils.leeEntero("Elije la opcion: ");
			switch(option) {
				case 0:
					valid=true;
					Utils.print("Has salido correctamente del menu competicion.");
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
        
        T tipo = (T) Utils.leeString("Ingrese el tipo de participante:"); // asumiendo que el tipo se ingresa como una cadena
        String horaString = Utils.leeString("Ingrese la hora de participación (en formato HH:mm:ss):");
        Time hora = Time.valueOf(horaString);
        double puntuacion = Utils.getDouble("Ingrese la puntuación obtenida:");
        Integer dorsal = Utils.leeEntero("Ingrese el número dorsal:");
      
        Participacion<T> newParticipacion = new Participacion<T>(tipo, hora, puntuacion, dorsal);
        
        if(repoParti.addParticipation(newParticipacion)==true) {
			Utils.print("Se ha introducido correctamente la participacion.");
		}else {
			Utils.print("No se ha introducido la participacion.");
		}
    }

	public void controllerEditParticipation() {
		int dorsal= Utils.leeEntero("Introduce el numero del dorsal de la participacion que deseas editar: ");
		repoParti.editParticipation(dorsal);
		
		if(repoParti.editParticipation(dorsal)==true) {
			Utils.print("Se ha editado correctamente la participacion.");
		}else {
			Utils.print("No se ha editado la participacion.");
		}
	}

	public void contollerShowParticipation() {
		int dorsal= Utils.leeEntero("Introduce el numero del dorsal de la participacion que deseas mostrar: ");
		repoParti.showParticipation(dorsal);
	}

	public void controllerDeleteParticipation() {
		int dorsal= Utils.leeEntero("Introduce el numero del dorsal de la participacion que deseas eliminar: ");
		repoParti.deleteParticipation(dorsal);
		
		if(repoParti.deleteParticipation(dorsal)==true) {
			Utils.print("Se ha eliminado correctamente la participacion.");
		}else {
			Utils.print("No se ha eliminado la participacion.");
		}
	}
}
