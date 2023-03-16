package proyectoGimnasia.controlador;


import java.util.List;

import proyectoGimnasia.interfaces.iControllerPrueba;
import proyectoGimnasia.interfaces.iGUIPrueba;
import proyectoGimnasia.model.RepoPrueba;
import proyectoGimnasia.model.DTO.Aparato;
import proyectoGimnasia.model.DTO.Categoria;
import proyectoGimnasia.model.DTO.Prueba;
import proyectoGimnasia.utils.Utils;
import proyectoGimnasia.vistas.PruebaView;




public class ControlPrueba implements iControllerPrueba {

	
	  private iGUIPrueba guiPrueba = new PruebaView();
	    private RepoPrueba repoPrueba = new RepoPrueba();

	    @Override
	    public void controlPruebaMenu(int op) {
	        int option;
	        boolean valid = false;

	        do {
	            guiPrueba.showEventMenu();
	            option = Utils.leeEntero("Elije la opcion: ");
	            switch (option) {
	                case 1:
	                    // falta llamar al nombre de competición actual
	                    break;
	                case 2:
	                    controllerAddPrueba();
	                    break;
	                case 3:
	                    controllerEditPrueba();
	                    break;
	                case 4:
	                    controllerShowPrueba();
	                    break;
	                case 5:
	                    controllerRemovePrueba();
	                    break;
	                case 6:
	
	                    break;
	                case 7:
	                    valid = true;
	                    Utils.print("Has salido correctamente del menu competicion.");
	                    break;
	                default:
	                    Utils.print("Opción incorrecta");
	                    break;
	            }
	        } while (!valid);
	    }

	    @Override
	    public void controllerAddPrueba() {
	        String tipo;
	        do {
	            tipo = Utils.leeString("Ingresa el tipo de prueba (individual/grupo): ");
	        } while (!tipo.equalsIgnoreCase("individual") && !tipo.equalsIgnoreCase("grupo"));

	        String categoriaString = Utils.leeString("Introduce la categoría: ");
	        Categoria categoria = null;
	        try {
	            categoria = Enum.valueOf(Categoria.class, categoriaString);
	        } catch (IllegalArgumentException e) {
	            System.out.println("La categoría introducida no es válida");
	            return;
	        }

	        String aparatoString = Utils.leeString("Introduce el aparato: ");
	        Aparato aparato = null;
	        try {
	            aparato = Enum.valueOf(Aparato.class, aparatoString);
	        } catch (IllegalArgumentException e) {
	            System.out.println("El aparato introducido no es válido");
	            return;
	        }

	        Prueba prueba = new Prueba();
	        prueba.setTipo(tipo);
	        prueba.setCategoria(categoria);
	        prueba.setAparato(aparato);

	        if (repoPrueba.addPrueba(prueba)) {
	            Utils.print("Prueba agregada correctamente");
	        } else {
	            Utils.print("Error al agregar la prueba");
	        }
	    }



	    @Override
	    public void controllerEditPrueba() {
	        List<Prueba> pruebas = repoPrueba.getPruebas();
	        if (pruebas.isEmpty()) {
	            Utils.print("No hay pruebas registradas.");
	        } else {
	            Utils.print("Lista de pruebas:");
	            for (int i = 0; i < pruebas.size(); i++) {
	                Utils.print(String.format("%d. %s", i+1, pruebas.get(i).toString()));
	            }
	            int index = Utils.leeEntero("Selecciona el índice de la prueba que quieres editar: ");
	            if (index < 1 || index > pruebas.size()) {
	                Utils.print("El índice seleccionado no es válido.");
	                return;
	            }
	            Prueba prueba = pruebas.get(index-1);

	            String tipo;
	            do {
	                tipo = Utils.leeString("Ingresa el tipo de prueba (individual/grupo): ");
	            } while (!tipo.equalsIgnoreCase("individual") && !tipo.equalsIgnoreCase("grupo"));

	            String categoriaString = Utils.leeString("Introduce la categoría: ");
	            Categoria categoria = null;
	            try {
	                categoria = Enum.valueOf(Categoria.class, categoriaString);
	            } catch (IllegalArgumentException e) {
	                Utils.print("La categoría introducida no es válida");
	                return;
	            }

	            String aparatoString = Utils.leeString("Introduce el aparato: ");
	            Aparato aparato = null;
	            try {
	                aparato = Enum.valueOf(Aparato.class, aparatoString);
	            } catch (IllegalArgumentException e) {
	                Utils.print("El aparato introducido no es válido");
	                return;
	            }

	            prueba.setTipo(tipo);
	            prueba.setCategoria(categoria);
	            prueba.setAparato(aparato);

	            Utils.print("La prueba ha sido editada correctamente.");
	        }
	    }

	           

	    @Override
	    public void controllerShowPrueba() {
	        List<Prueba> pruebas = repoPrueba.getPruebas();

	        if (pruebas.isEmpty()) {
	            Utils.print("No hay pruebas registradas.");
	        } else {
	            for (int i = 0; i < pruebas.size(); i++) {
	                Utils.print("Índice: " + i);
	                Utils.print(pruebas.get(i).toString());
	            }
	        }
	    }



	    @Override
	    public void controllerRemovePrueba() {
	        List<Prueba> pruebas = repoPrueba.getPruebas();
	        if (pruebas.isEmpty()) {
	            Utils.print("No hay pruebas registradas.");
	        } else {
	            Utils.print("Lista de pruebas:");
	            for (int i = 0; i < pruebas.size(); i++) {
	                Utils.print(String.format("%d. %s", i+1, pruebas.get(i).toString()));
	            }
	            int index = Utils.leeEntero("Introduce el índice de la prueba que deseas eliminar: ");
	            if (index < 1 || index > pruebas.size()) {
	                Utils.print("El índice seleccionado no es válido.");
	                return;
	            }
	            Prueba prueba = pruebas.get(index-1);
	            if (repoPrueba.deletePrueba(prueba)) {
	                Utils.print("Prueba eliminada correctamente.");
	            } else {
	                Utils.print("Error al eliminar la prueba.");
	            }
	        }
	    }



	
}
