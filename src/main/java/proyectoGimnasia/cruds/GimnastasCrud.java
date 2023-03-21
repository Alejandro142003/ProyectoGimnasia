package proyectoGimnasia.cruds;

import proyectoGimnasia.model.RepoGimnasta;
import proyectoGimnasia.model.DTO.Gimnasta;
import proyectoGimnasia.utils.Utils;

import java.util.Iterator;
import java.util.List;


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
			String dni = Utils.leeString("Introduce el dni del gimnasta que desea modificar: ");
			for (Gimnasta g:gim) {
				if (g.getDni() == dni) {
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

	public boolean deleteGymnast(int dorsal) {
		RepoGimnasta rg = RepoGimnasta.newInstance();
		List<Gimnasta> gim = rg.getGimnastas();
		Gimnasta g = new Gimnasta();
		boolean result=gim.remove(g);
		if (result) {
			rg.setGimnastas(gim);
			rg.guardarXML(gim);
		}
		return result;
	}

	public Gimnasta showGymnast(String dni) {
		RepoGimnasta rg = RepoGimnasta.newInstance();
		List<Gimnasta> gim = rg.getGimnastas();
		Iterator<Gimnasta> it = gim.iterator();
		Gimnasta g = it.next();
		while(it.hasNext()) {
			if(g.getDni() == dni) {
				g.toString();
			} else {
				Utils.print("No existe ningun gimnasta con el siguiente dni "+dni);
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
				Utils.print("No existe ningún gimnasta para mostrar");
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
