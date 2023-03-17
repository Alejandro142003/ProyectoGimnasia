package proyectoGimnasia.cruds;

import proyectoGimnasia.model.RepoGimnasta;
import proyectoGimnasia.model.DTO.Competicion;
import proyectoGimnasia.model.DTO.Gimnasta;
import proyectoGimnasia.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import proyectoGimnasia.interfaces.iRepoGimnasta;

public class GimnastasCrud{
    
	public boolean addGymnast(Gimnasta g) {
		RepoGimnasta rg = RepoGimnasta.newInstance();
		List<Gimnasta> gim = rg.getGimnastas();
		boolean result=gim.add(g);
		if (result) {
			rg.setGimnastas(gim);
			rg.guardarXML(gim);
		}
		return result;

	}

	public void editGymnast() {
		RepoGimnasta rg = RepoGimnasta.newInstance();
		List<Gimnasta> gim = rg.getGimnastas();
		showAllGymnasts();
		if (gim.isEmpty()) {
			Utils.print("No hay gimnastas para editar.");
		}else {
			int dorsal = Utils.leeEntero("Introduce el dorsal del gimnasta que desea modificar: ");
			for (Gimnasta g:gim) {
				if (g.getDorsal() == dorsal) {
					String nombre = Utils.leeString("Introduce el nombre: ");
					g.setNombre(nombre);
					String correo = Utils.leeString("Introduce un correo electrónico: ");
					g.setCorreo(correo);
					int telefono = Utils.leeEntero("Introduce un numero de telefono; ");
					g.setTelefono(telefono);
					String categoria = Utils.leeString("Introduce la categoria del Gimnasta: ");
					g.setCategoria(categoria);
					String club = Utils.leeString("Introduce el club del Gimnasta: ");
					g.setClub(club);
					rg.setGimnastas(gim);
					rg.guardarXML(gim);
				}
			}
		}
	}

	public void deleteGymnast() {
		showAllGymnasts();
	}

	public Gimnasta showGymnast(int dorsal) {
		RepoGimnasta rg = RepoGimnasta.newInstance();
		List<Gimnasta> gim = rg.getGimnastas();
		Gimnasta g = null;
		for(Gimnasta gimnasta:gim) {
			if(gimnasta.getDorsal() == dorsal) {
				g=gimnasta;
			} else {
				Utils.print("No existe ningun gimnasta con el siguiente dorsal "+dorsal);
			}
		}
		return g;
	}

	public String showAllGymnasts() {
		RepoGimnasta rg = RepoGimnasta.newInstance();
		List<Gimnasta> gim = rg.getGimnastas();
		String result ="";
		for (Gimnasta gimnasta:gim) {
			if (gim.isEmpty()) {
				Utils.print("No existe ningún gimnasta para mostrar");//Quizas haya que cambiarlo por return+="";
			} else {
				if (gimnasta !=null ) {
					result+=gimnasta+"\n";
				}else {
					result+="\n";
				}
			}
		}
		return result;
	}
}