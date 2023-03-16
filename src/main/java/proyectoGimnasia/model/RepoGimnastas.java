package proyectoGimnasia.model;

import proyectoGimnasia.model.DTO.Gimnasta;
import proyectoGimnasia.model.DTO.Grupo;
import proyectoGimnasia.model.DTO.Participacion;
import proyectoGimnasia.model.DTO.Prueba;
import proyectoGimnasia.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import proyectoGimnasia.interfaces.iRepoGimnasta;

public class RepoGimnastas implements iRepoGimnasta{
	private ArrayList<Gimnasta> gimnastas = new ArrayList<Gimnasta>();
    private Gimnasta gimnasta = new Gimnasta();
    
	public boolean addGymnast(Gimnasta gimnasta) {
		
		boolean result=false;
		if(!gimnastas.contains(gimnasta) && gimnasta.getNombre()==null) {
			gimnastas.add(gimnasta);
			result=true;
		}
		return result;

	}

	public boolean editGymnast(int dorsal) {
		boolean result = false;
		if (gimnastas.isEmpty()) {
			Utils.print("No hay gimnastas para editar.");
		} else {
			for(Gimnasta gimnasta:gimnastas) {
				Gimnasta.
			}
		}
		return result;
		
	}

	public void deleteGymnast(int dorsal) {
		// TODO Auto-generated method stub
		
	}

	public Gimnasta showGymnast(int dorsal) {
		Gimnasta g = null;
		for(Gimnasta gimnasta:gimnastas) {
			if(gimnasta.getDorsal() == dorsal) {
				g=gimnasta;
			} else {
				Utils.print("No existe ningun gimnasta con el siguiente dorsal "+dorsal);
			}
		}
		return g;
	}

	@Override
	public String showAllGymnasts() {
		String result ="";
		for (Gimnasta gimnasta:gimnastas) {
			if (gimnastas.isEmpty()) {
				Utils.print("No existe ningún gimnasta para mostrar");//Quizas haya que cambiarlo por return+="";
			} else {
				if (gimnasta !=null ) {
					result+=gimnasta.toString();
				}else {
					result+="\n";
				}
			}
		}
		return result;
	}
}
