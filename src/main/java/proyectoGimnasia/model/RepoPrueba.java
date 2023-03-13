package proyectoGimnasia.model;

import proyectoGimnasia.interfaces.iRepoPrueba;
import proyectoGimnasia.model.DTO.Aparato;
import proyectoGimnasia.model.DTO.Categoria;
import proyectoGimnasia.model.DTO.Prueba;
import proyectoGimnasia.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RepoPrueba implements iRepoPrueba {
    private List<Prueba> pruebas;

    public RepoPrueba() {
        pruebas = new ArrayList<Prueba>();
    }

    /**
     * Método para añadir por consola una prueba
     */
    public void AgregarPrueba() {
        //con esto consigo que el usuario entre un String y solo tenga las posiblidades de individual o grupo. Admine mayúsculas
    	String tipo = "";
        while (!tipo.equalsIgnoreCase("individual") && !tipo.equalsIgnoreCase("grupo")) {
            tipo = Utils.leeString("Ingrese el tipo de la prueba (individual o grupo): ");
            if (!tipo.equalsIgnoreCase("individual") && !tipo.equalsIgnoreCase("grupo")) {
                System.out.println("Tipo de prueba inválido. Por favor ingrese 'individual' o 'grupo'.");
            }
        }
        
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

        Prueba prueba = new Prueba(tipo, categoria, aparato);
        AgregarPrueba(prueba);
    }


    /**
     * Método para conseguir que el método AgregarPrueba() funcione y se pueda añadir la línea AgregarPrueba(prueba); al final
     */
    public void AgregarPrueba(Prueba prueba) {
        pruebas.add(prueba);
    }

    /**
     * Metodo para mostrar las pruebas creadas por consola y creadas a fuego
     */
    public List<Prueba> MostrarPrueba() {
    	for(Prueba prueba: pruebas) {
    		System.out.println(prueba.toString());
    	}
        return pruebas;
    }
  


    //Compruebo primero que no haya pruebas y luego elimino.
    public void EliminarPrueba() {
    	Scanner scanner = new Scanner(System.in);
        if (pruebas.isEmpty()) {
            System.out.println("No hay pruebas disponibles para eliminar.");
            return;
        }
        //mostrar la lista de pruebas que tenemos
        System.out.println("Lista de pruebas:");
        List<Prueba> pruebasMostradas = MostrarPrueba();
        
        //es el valor se va a utilizar para verificar que el número que ingresa el usuario es válido
        int index = -1;
        //bucle que se ejecuta mientras index sea menor a cero o >= al tamaño de la lista de pruebas
        while (index < 0 || index >= pruebasMostradas.size()) {
            System.out.print("Seleccione la prueba que desea eliminar (ingrese el número correspondiente): ");
            try {
            	//Integer.parseInt() es para convertir la entrada del usuario en un número entero
                index = Integer.parseInt(scanner.nextLine()) - 1;
                //Si el usuario ingresa un valor no numérico se produce el error
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un número válido.");
            }
        }
        //se borra la prueba
        Prueba prueba = pruebasMostradas.get(index);
        pruebas.remove(prueba);

        System.out.println("La prueba se ha eliminado");
    }



    /**
     * Método que editar una prueba ya creada
     */
    public void EditarPrueba(Prueba prueba, String nuevoTipo, Categoria nuevaCategoria, Aparato nuevoAparato) {
    	//PARA VER TODAS LAS PRUEBAS QUE HAY ANTES DE HACER NADA
    	Scanner scanner = new Scanner(System.in);
        if (pruebas.isEmpty()) {
            System.out.println("No hay pruebas disponibles para eliminar.");
            return;
        }
        //mostrar la lista de pruebas que tenemos
        System.out.println("Lista de pruebas:");
        List<Prueba> pruebasMostradas = MostrarPrueba();
        
        //es el valor se va a utilizar para verificar que el número que ingresa el usuario es válido
        int index = -1;
        //bucle que se ejecuta mientras index sea menor a cero o >= al tamaño de la lista de pruebas
        while (index < 0 || index >= pruebasMostradas.size()) {
            System.out.print("Seleccione la prueba que desea eliminar (ingrese el número correspondiente): ");
            try {
            	//Integer.parseInt() es para convertir la entrada del usuario en un número entero
                index = Integer.parseInt(scanner.nextLine()) - 1;
                //Si el usuario ingresa un valor no numérico se produce el error
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un número válido.");
            }
        }
    	
    
    	//Buscamos una prueba con los mismos valores para evitar editar una prueba y esta sea igual que otra ya creada
        boolean existeOtraPruebaIgual = pruebas.stream()
            .anyMatch(p -> p != prueba && p.getTipo().equals(nuevoTipo) 
                        && p.getCategoria() == nuevaCategoria 
                        && p.getAparato() == nuevoAparato);
        
        if (existeOtraPruebaIgual) {
            System.out.println("Ya existe otra prueba con el mismo tipo, categoría y aparato");
            return;
        }
        
        //Si ha pasado el control de antes ya simplemente cambiamos los valores
        prueba.setTipo(nuevoTipo);
        prueba.setCategoria(nuevaCategoria);
        prueba.setAparato(nuevoAparato);
        
        System.out.println("La prueba se ha actualizado correctamente");
    }

}

