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

	public boolean editGymnast(Gimnasta g) {
		boolean result = true;
		RepoGimnasta rg = RepoGimnasta.newInstance();
		List<Gimnasta> gim = rg.getGimnastas();
		showAllGymnasts();
		if (gim.isEmpty()) {
			Utils.print("No hay gimnastas para editar.");
		}else {
			for (Gimnasta gimnasta : gim) {
				if (gimnasta.equals(g)) {
					rg.setGimnastas(gim);
					rg.guardarXML(gim);
					result = true;
				}
			}
		}
		return result;
	}

	public boolean deleteGymnast(Gimnasta g) {
		RepoGimnasta rg = RepoGimnasta.newInstance();
		List<Gimnasta> gim = rg.getGimnastas();
		boolean result=gim.remove(g);
		if (result) {
			rg.setGimnastas(gim);
			rg.guardarXML(gim);
		}
		return result;
	}

	public Gimnasta findGymnast(String dni) {
		RepoGimnasta rg = RepoGimnasta.newInstance();
		List<Gimnasta> gim = rg.getGimnastas();
		Gimnasta gimnasta = null;
		for(Gimnasta g : gim) {
			if(g.getDni().equals(dni)) {
				gimnasta = g;
				break;
			}
		}
		return gimnasta;
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
