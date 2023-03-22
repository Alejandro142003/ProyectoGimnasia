package proyectoGimnasia.cruds;

import java.util.Iterator;
import java.util.List;

import proyectoGimnasia.model.RepoGimnasta;
import proyectoGimnasia.model.DTO.Grupo;
import proyectoGimnasia.utils.Utils;

public class GruposCrud {

	public boolean addGroup(Grupo g) {
		RepoGimnasta rg = RepoGimnasta.newInstance();
		List<Grupo> gru = rg.getGrupos();
		boolean result=gru.add(g);
		if (result) {
			rg.setGrupos(gru);
			rg.guardarXMLGrupo(gru);
		}
		return result;
	}

	public boolean editGroup(Grupo g) {
		boolean result = true;
		RepoGimnasta rg = RepoGimnasta.newInstance();
		List<Grupo> gru = rg.getGrupos();
		showAllGroups();
		if (gru.isEmpty()) {
			Utils.print("No hay gimnastas para editar.");
		}else {
			for (Grupo grupo : gru) {
				if (grupo.equals(g)) {
					rg.setGrupos(gru);
					rg.guardarXMLGrupo(gru);
					result = true;
				}
			}
		}
		return result;
	}

	public boolean deleteGroup(Grupo g) {
		RepoGimnasta rg = RepoGimnasta.newInstance();
		List<Grupo> gru = rg.getGrupos();
		boolean result = gru.remove(g);
		if (result) {
			rg.setGrupos(gru);
			rg.guardarXMLGrupo(gru);
		}
		return result;
	}

	public Grupo findGroup(String groupName) {
		RepoGimnasta rg = RepoGimnasta.newInstance();
		List<Grupo> gru = rg.getGrupos();
		Grupo grupo = null;
		for(Grupo g : gru) {
			if(g.getGroupName().equals(groupName)) {
				grupo = g;
				break;
			}
		}
		return grupo;
	}
	
	public Grupo showGroups(String groupName) {
		RepoGimnasta rg = RepoGimnasta.newInstance();
		List<Grupo> gru = rg.getGrupos();
		Iterator<Grupo> it = gru.iterator();
		Grupo g = it.next();
		while(it.hasNext()) {
			if(g.getGroupName() == groupName) {
				g.toString();
			} else {
				Utils.print("No existe ningun gimnasta con el siguiente dni "+groupName);
			}
		}
		return g;
	}
	
	
	public String showAllGroups() {
		RepoGimnasta rg = RepoGimnasta.newInstance();
		List<Grupo> gru = rg.getGrupos();
		String result ="";
		for (Grupo grupo:gru) {
			if (gru.isEmpty()) {
				Utils.print("No existe ningún gimnasta para mostrar");
			} else {
				if (grupo !=null ) {
					result+=grupo+"\n";
				}else {
					result+="\n";
				}
			}
		}
		return result;
	}
}
