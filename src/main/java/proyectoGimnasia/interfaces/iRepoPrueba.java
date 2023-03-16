package proyectoGimnasia.interfaces;

import java.util.List;

import proyectoGimnasia.model.DTO.Aparato;
import proyectoGimnasia.model.DTO.Categoria;
import proyectoGimnasia.model.DTO.Prueba;

public interface iRepoPrueba {
	public boolean addPrueba(Prueba p);
	
	public boolean editPrueba(Prueba p);
	
	public boolean deletePrueba(Prueba p);
	
	public List<Prueba> getPruebas();

	Prueba findPrueba(String tipo, Categoria categoria, Aparato aparato);
}

