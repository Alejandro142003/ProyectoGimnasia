package proyectoGimnasia.interfaces;

import java.util.List;

import proyectoGimnasia.model.DTO.Aparato;
import proyectoGimnasia.model.DTO.Categoria;
import proyectoGimnasia.model.DTO.Prueba;

public interface iRepoPrueba {
    void AgregarPrueba();
    void AgregarPrueba(Prueba prueba);
    List<Prueba> MostrarPrueba();
    void EliminarPrueba();
    public void EditarPrueba(Prueba prueba, String nuevoTipo, Categoria nuevaCategoria, Aparato nuevoAparato);
}

