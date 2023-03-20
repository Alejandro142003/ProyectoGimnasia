package proyectoGimnasia.controlador;


import java.util.ArrayList;
import java.util.List;

import proyectoGimnasia.cruds.PruebaCrud;
import proyectoGimnasia.interfaces.iControllerPrueba;
import proyectoGimnasia.interfaces.iGUIPrueba;
import proyectoGimnasia.model.RepoCompeticiones;
import proyectoGimnasia.model.RepoPrueba;
import proyectoGimnasia.model.DTO.Aparato;
import proyectoGimnasia.model.DTO.Categoria;
import proyectoGimnasia.model.DTO.Competicion;
import proyectoGimnasia.model.DTO.Prueba;
import proyectoGimnasia.model.DTO.Tipo;
import proyectoGimnasia.utils.Utils;
import proyectoGimnasia.vistas.PruebaView;




public class ControlPrueba implements iControllerPrueba {

	
	  private iGUIPrueba guiPrueba = new PruebaView();
	    private RepoPrueba repoPrueba = new RepoPrueba();
	    private Prueba prueba = new Prueba();
	    private PruebaCrud crud = new PruebaCrud();
	    List<Prueba> pruebas = new ArrayList<>();
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
	                	controllerShowAllPruebas();
	                    break;
	                case 5:
	                	controllerShowPrueba();
	                    break;
	                case 6:
	                	controllerRemovePrueba();
	                    break;
	                case 7:
	                   
	                    break;
	                case 8:
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
	       String nombre = Utils.leeString("Introduce la competición para añadirle pruebas: ");
	       guiPrueba.TipoPrueba();
	       Tipo tipo = Utils.validTipo("Introduce el tipo de prueba: ");
	       guiPrueba.CategoriaPrueba();
	       Categoria categoria = Utils.validCategoria("Introduce la categoría: ");
	       guiPrueba.AparatoPrueba();
	       Aparato aparato = Utils.validAparato("Introduce el aparato: ");
	       Prueba prueba = new Prueba(tipo, categoria, aparato);
	       if(crud.agregaPrueba(nombre, prueba)==true){
	    	   Utils.print("Se ha introducido correctamente la prueba");
	       }else {
	    	   Utils.print("No se ha introducido correctamente la prueba");
	       }
	      
	       }





	    @Override
	    public void controllerEditPrueba() {
	    	 String nombre = Utils.leeString("Introduce la competición para editarle prueba: ");
	    	 Tipo tipo = Utils.validTipo("Introduce el tipo de prueba: ");
			 Categoria categoria = Utils.validCategoria("Introduce la categoríade la prueba: ");
			 Aparato aparato = Utils.validAparato("Introduce el aparato de la prueba: ");
			 Prueba p = new Prueba(tipo, categoria, aparato);
	    	 if(crud.editarPrueba(nombre, p)==true) {
	    		 Utils.print("Se ha editado correctamente");
	    	 }else{
	    		 Utils.print("No se ha encontrado la prueba");
	    	 }
	    }



	           

	    @Override
	    public void controllerShowPrueba() {
	    	String nombre = Utils.leeString("Introduce la competición de la que quieres ver sus pruebas: ");
	    	Tipo tipo = Utils.validTipo("Introduce el tipo de prueba: ");
		    Categoria categoria = Utils.validCategoria("Introduce la categoríade la prueba: ");
		    Aparato aparato = Utils.validAparato("Introduce el aparato de la prueba: ");
	    	Prueba p = new Prueba(tipo, categoria, aparato);
	    	crud.mostrarPrueba(nombre, p);
	    	}
	    	
	    	
	        
	    



	    @Override
	    public void controllerRemovePrueba() {
	    	String nombre = Utils.leeString("Introduce la competición de la que quieres ver sus pruebas: ");
	    	 Tipo tipo = Utils.validTipo("Introduce el tipo de prueba: ");
		     Categoria categoria = Utils.validCategoria("Introduce la categoría: ");
		     Aparato aparato = Utils.validAparato("Introduce el aparato: ");
		     for(Prueba p: pruebas) {
		    		if(p.equals(tipo)&&p.equals(categoria)&&p.equals(aparato)) {
		    			   if(crud.eliminaPrueba(nombre, p)==true) {
		    				   Utils.print("Se ha eliminado correctamente");
		    				   break;
		    			   }else {
		    				   Utils.print("No se ha eliminado la prueba");
		    			   }
		    			
		    			
		    		}
		    	}
	    }
	    
	    public void controllerShowAllPruebas() {
	    	crud.mostrarTodasLasPruebas();
	    	
	    }

	    


	
}
