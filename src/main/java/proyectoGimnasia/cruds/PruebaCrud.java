package proyectoGimnasia.cruds;

import proyectoGimnasia.interfaces.iRepoPrueba;
import proyectoGimnasia.model.DTO.Categoria;
import proyectoGimnasia.model.DTO.Prueba;
import proyectoGimnasia.model.DTO.Aparato;
import proyectoGimnasia.model.RepoPrueba;

import java.util.List;

public class PruebaCrud {
    private iRepoPrueba repoPrueba;

    public PruebaCrud() {
        this.repoPrueba = new RepoPrueba();
    }

    public PruebaCrud(iRepoPrueba repoPrueba) {
        this.repoPrueba = repoPrueba;
    }

    public boolean crearPrueba(String tipo, Categoria categoria, Aparato aparato) {
        Prueba prueba = new Prueba(tipo, categoria, aparato);
        return repoPrueba.addPrueba(prueba);
    }

    public boolean actualizarPrueba(Prueba prueba) {
        return repoPrueba.editPrueba(prueba);
    }

    public boolean eliminarPrueba(String tipo, Categoria categoria, Aparato aparato) {
        Prueba prueba = new Prueba(tipo, categoria, aparato);
        return repoPrueba.deletePrueba(prueba);
    }

    public List<Prueba> listarPruebas() {
        return repoPrueba.getPruebas();
    }

    public Prueba buscarPrueba(String tipo, Categoria categoria, Aparato aparato) {
        List<Prueba> pruebas = repoPrueba.getPruebas();
        for (Prueba p : pruebas) {
            if (p.getTipo().equals(tipo) && p.getCategoria().equals(categoria) && p.getAparato().equals(aparato)) {
                return p;
            }
        }
        return null;
    }

}

