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
	    
	    public void controlPruebaMenu2(int op) {
	        int option;
	        boolean valid = false;
	        do {
	            guiPrueba.TipoPrueba();
	            option = Utils.leeEntero("Elije la opcion: ");
	            switch (option) {
	                case 1:
	                    Utils.print("Ha elegido 'Individual'");
	                    valid = true;
	                    break;
	                case 2:
	                    Utils.print("Ha elegido 'Grupo'");
	                    valid = true;
	                    break;
	                default:
	                    Utils.print("Opción incorrecta");
	                    break;
	            }
	        } while (!valid);
	    }

	    public void controlPruebaMenu3(int op) {
	        int option;
	        boolean valid = false;
	        
	        Prueba prueba = new Prueba(); 
	        
	        do {
	            guiPrueba.CategoriaPrueba();
	            option = Utils.leeEntero("Elije la opcion: ");
	            
	            switch (option) {
	                case 1:
	                    prueba.setCategoria(Categoria.Prebenjamin);
	                    valid = true;
	                    break;
	                case 2:
	                    prueba.setCategoria(Categoria.Benjamin);
	                    valid = true;
	                    break;
	                case 3:
	                    prueba.setCategoria(Categoria.Alevin);
	                    valid = true;
	                    break;
	                case 4:
	                    prueba.setCategoria(Categoria.Infantil);
	                    valid = true;
	                    break;
	                case 5:  
	                    prueba.setCategoria(Categoria.Junior);
	                    valid = true;
	                    break;
	                case 6:
	                    prueba.setCategoria(Categoria.Senior);
	                    valid = true;
	                    break;
	                default:
	                    Utils.print("Opción incorrecta");
	                    break;
	            }
	        } while (!valid);
	    }

	    public void controlPruebaMenu4(int op) {
	        int option;
	        boolean valid = false;
	        
	        Prueba prueba = new Prueba(); 
	        
	        do {
	            guiPrueba.CategoriaPrueba();
	            option = Utils.leeEntero("Elije la opcion: ");
	            
	            switch (option) {
	                case 1:
	                    prueba.setAparato(Aparato.Mazas); 
	                    valid = true;
	                    break;
	                case 2:
	                    prueba.setAparato(Aparato.Aro);
	                    valid = true;
	                    break;
	                case 3:
	                    prueba.setAparato(Aparato.Cinta);
	                    valid = true;
	                    break;
	                case 4:
	                    prueba.setAparato(Aparato.Cuerda);
	                    valid = true;
	                    break;
	                case 5: 
	                    prueba.setAparato(Aparato.ManosLibres);
	                    valid = true;
	                    break;
	                default:
	                    Utils.print("Opción incorrecta");
	                    break;
	            }
	        } while (!valid);
	    }



	    
	    @Override
	    public void controllerAddPrueba() {
	        int tipoPrueba;
	        int categoriaPrueba;
	        int aparatoPrueba;

	        do {
	            guiPrueba.TipoPrueba();
	            tipoPrueba = Utils.leeEntero("Elije el tipo de prueba: ");
	        } while (tipoPrueba < 1 || tipoPrueba > 2);

	        do {
	            guiPrueba.CategoriaPrueba();
	            categoriaPrueba = Utils.leeEntero("Elije la categoria de la prueba: ");
	        } while (categoriaPrueba < 1 || categoriaPrueba > 6);

	        do {
	            guiPrueba.AparatoPrueba();
	            aparatoPrueba = Utils.leeEntero("Elije el aparato de la prueba: ");
	        } while (aparatoPrueba < 1 || aparatoPrueba > 5);

	        // Verificar si ya existe una prueba con el mismo tipo, categoría y aparato
	        for (Prueba prueba : repoPrueba.getPruebas()) {
	            if (prueba.getTipo().equalsIgnoreCase(tipoPrueba == 1 ? "Individual" : "Grupo")
	                    && prueba.getCategoria() == Categoria.values()[categoriaPrueba - 1]
	                    && prueba.getAparato() == Aparato.values()[aparatoPrueba - 1]) {
	                Utils.print("Ya existe una prueba con el mismo tipo, categoría y aparato. No se puede crear otra.");
	                return;
	            }
	        }

	        Prueba prueba = new Prueba();
	        prueba.setTipo(tipoPrueba == 1 ? "Individual" : "Grupo");
	        prueba.setCategoria(Categoria.values()[categoriaPrueba - 1]);
	        prueba.setAparato(Aparato.values()[aparatoPrueba - 1]);

	        repoPrueba.addPrueba(prueba);

	        Utils.print("Prueba creada correctamente.");
	    }





	    @Override
	    public void controllerEditPrueba() {
	        List<Prueba> pruebas = repoPrueba.getPruebas();
	        if (pruebas.isEmpty()) {
	            Utils.print("No hay pruebas registradas.");
	            return;
	        }

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

	        int tipoPrueba;
	        do {
	            guiPrueba.TipoPrueba();
	            tipoPrueba = Utils.leeEntero("Elije el tipo de prueba: ");
	        } while (tipoPrueba < 1 || tipoPrueba > 2);

	        int categoriaPrueba;
	        do {
	            guiPrueba.CategoriaPrueba();
	            categoriaPrueba = Utils.leeEntero("Elije la categoria de la prueba: ");
	        } while (categoriaPrueba < 1 || categoriaPrueba > 6);

	        int aparatoPrueba;
	        do {
	            guiPrueba.AparatoPrueba();
	            aparatoPrueba = Utils.leeEntero("Elije el aparato de la prueba: ");
	        } while (aparatoPrueba < 1 || aparatoPrueba > 5);

	        prueba.setTipo(tipoPrueba == 1 ? "Individual" : "Grupo");
	        prueba.setCategoria(Categoria.values()[categoriaPrueba - 1]);
	        prueba.setAparato(Aparato.values()[aparatoPrueba -1]);

	        Utils.print("La prueba ha sido editada correctamente.");
	    }


	           

	    @Override
	    public void controllerShowPrueba() {
	        List<Prueba> pruebas = repoPrueba.getPruebas();

	        if (pruebas.isEmpty()) {
	            Utils.print("No hay pruebas registradas.");
	        } else {
	                Utils.print(pruebas.toString());
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
