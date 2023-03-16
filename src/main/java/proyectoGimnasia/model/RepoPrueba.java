package proyectoGimnasia.model;

import proyectoGimnasia.interfaces.iRepoPrueba;
import proyectoGimnasia.model.DTO.Aparato;
import proyectoGimnasia.model.DTO.Categoria;
import proyectoGimnasia.model.DTO.Prueba;

import java.util.ArrayList;
import java.util.List;

public class RepoPrueba implements iRepoPrueba {
    private List<Prueba> pruebas;

    public RepoPrueba() {
        pruebas = new ArrayList<Prueba>();
    }

    @Override
    public boolean addPrueba(Prueba p) {
        if (pruebas.contains(p)) {
            return false;
        } else {
            pruebas.add(p);
            return true;
        }
    }

    @Override
    public Prueba findPrueba(String tipo, Categoria categoria, Aparato aparato) {
        for (Prueba p : pruebas) {
            if (p.getTipo().equals(tipo) && p.getCategoria().equals(categoria) && p.getAparato().equals(aparato)) {
                return p;
            }
        }
        return null;
    }


    @Override
    public boolean editPrueba(Prueba p) {
        int index = pruebas.indexOf(p);
        if (index != -1) {
            pruebas.set(index, p);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deletePrueba(Prueba p) {
        return pruebas.remove(p);
    }

    @Override
    public List<Prueba> getPruebas() {
        return pruebas;
    }


}


