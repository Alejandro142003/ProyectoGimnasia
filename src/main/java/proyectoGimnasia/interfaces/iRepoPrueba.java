package proyectoGimnasia.interfaces;

import java.util.List;

import proyectoGimnasia.model.DTO.Aparato;
import proyectoGimnasia.model.DTO.Categoria;
import proyectoGimnasia.model.DTO.Prueba;

public interface iRepoPrueba {
	
	public List<Prueba> getPruebas();
	
	public boolean addPrueba(Prueba p);
	
	public Prueba showPrueba(String tipo, Categoria categoria, Aparato aparato);
	
	public String showAllPruebas();
}

