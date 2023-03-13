package proyectoGimnasia.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {
	
	/**
	 * Metodo que valida si ingresas un obj tipo String.
	 * @param mensaje: cadena que le muestras al usuario.
	 * @return: String ya validado.
	 */
	 public static String leeString(String mensaje) {
		  Scanner sc = new Scanner (System.in);
		  String result = null;
		  boolean valid = false;
		  do {
			try {
				System.out.print(mensaje);
				result = sc.nextLine();
				valid = true;
			} catch (Exception e) {
				System.out.println("Error. Introduzca una cadena");
				sc.nextLine();
			}
		} while (!valid);
		  
		  return result;
		  
	  }
	  
	  /**
	   * Metodo que valida si el caracter introducido es  entero.
	   * @param mensaje: cadena que le muestras al usuario.
	   * @return: el entero validado.
	   */
	  public static int leeEntero(String mensaje) {
		  Scanner sc = new Scanner (System.in);
		  int result = 0;
		  boolean valid = false;
		  do {
			try {
				System.out.print(mensaje);
				result = sc.nextInt();
				valid = true;
			} catch (Exception e) {
				System.out.println("Error. Introduzca un entero");
				sc.nextLine();
			}
		} while (!valid);
		  return result;
	  }
	  
	  
	  /**
	  * VALIDA DNI
	  * **/
	  /**
	   * Metodo que valida si el DNI introducido es correcto (devolviendonos true).
	   * @param DNI : la cadena (DNI) a validar.
	   * @return: true o false dependiendo de si cumple los requisitos.
	   */
	  public static boolean validaDNI (String DNI) {
		  
		  boolean result=false;


		  if (DNI.length()==9 && Character.isLetter(DNI.charAt(8))==true) {
			  
			  char letraMayuscula=((DNI.substring(8)).toUpperCase()).charAt(0);
			  	if(soloNumero(DNI)==true && letraDNI(DNI)==letraMayuscula) {
				  result = true;
			  }
		  }
		  return result;
		  
	  }
	  /**
	   * Metodo que valida si los numeros del DNI son 8 ademas de estar comprendidos entre 0 y 9.
	   * @param DNI: la cadena a validar.
	   * @return: la cadena validada.
	   */
	private static boolean soloNumero(String DNI) {
		boolean result=true;
		
		String numero=DNI.substring(0,8);
		for (int i = 0; i < 8 && result; i++) {
			char digito=DNI.charAt(i);
			if(digito<'0' || digito>'9') {
				result=false;
			}
			
		} 
		return result;
			
		
	}
	/**
	 * Metodo que comprueba que la letra del DNI sea la correcta 
	 * @param dni: la cadena a validar.
	 * @return: la cadena validada.
	 */
	public static char letraDNI(String dni){
		int miDNI=Integer.parseInt(dni.substring(0,8));
		int resto=0;
		char miLetra=' ';
		char[] asignacionLetra={'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
		
		resto=miDNI % 23;
		miLetra=asignacionLetra[resto];
		return miLetra;
		}
	
	/**
	 * Metodo que lee el dni y lo valida a traves de los metodos anteriores.
	 * @param mensaje: cadena que le muestras al usuario.
	 * @return: el dni ya validado.
	 */
	public static String devuelveDNI(String mensaje) {
		Scanner sc = new Scanner (System.in);
		boolean valid = false;
		String dni= "";
		System.out.print(mensaje);
		do {
			try {
			
				dni=sc.nextLine();
				if(validaDNI(dni)==true) {
					valid = true;
				}else {
					System.out.println("DNI invalido, vuelva a introducirlo: ");
				}
			} catch (Exception e) {
				System.out.println("Error, introduzca una cadena");
				sc.nextLine();
			}
				
			
		} while (!valid);
			
		return dni;
	}
	
	public static void print(String mensaje) {
		System.out.println(mensaje);
	}
	
	public static void printObject(Object o) {
		System.out.println(o);
	}
	
	public static double getDouble(String text) {
	    
	    boolean validNum = true;
	    Scanner scan = new Scanner(System.in);
	    double num = 0;

	    do {   
	      try {
	    	Utils.print(text);
	        num = scan.nextDouble();

	        if (num < 0) {
	          validNum = true;
	          Utils.print("Debe ingresar obligatoriamente un numero valido.");       
	        }else{
	          validNum = false;
	        }

	        
	      }  catch (InputMismatchException ex) {
	        
	        scan.nextLine();
	        validNum = true;
	        Utils.print("Debe ingresar obligatoriamente un numero valido.");
	        

	      } catch (Exception e) {
	        
	        scan.nextLine();
	        validNum = true;
	        Utils.print("Debe ingresar obligatoriamente un numero valido.");

	      }
	    } while(validNum);
	    
	    return num;
	  }
	
	
}
