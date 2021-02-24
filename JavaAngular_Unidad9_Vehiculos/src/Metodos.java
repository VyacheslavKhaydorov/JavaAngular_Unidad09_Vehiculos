/**
 * 
 */

import java.util.Scanner;
import java.util.ArrayList;
/**
 * @author Cesar Torrelles, Ingrid Dominguez, Vyacheslav Khaydorov
 *
 */
public class Metodos {
	
	public static void introducirDatos (Scanner teclado, String marcaRuedasDelanteras, double diametroRuedasDelanteras, String marcaRuedasTraseras, double diametroRuedasTraseras) {
		System.out.println("Introduce la marca de las ruedas delanteras:");
		marcaRuedasDelanteras = teclado.next();
		System.out.println("Introduce el diámetro de las ruedas delanteras:");
		diametroRuedasDelanteras = teclado.nextDouble();
		System.out.println("Introduce la marca de las ruedas traseras:");
		marcaRuedasTraseras = teclado.next();
		System.out.println("Introduce el diámetro de las ruedas traseras:");
		diametroRuedasTraseras = teclado.nextDouble();
	}
	
	public static String comprobarMatricula (String matricula, String matricula_DEF) {
		if (matricula.toUpperCase().matches("^[0-9]{4}[A-Z]{3}$")) {
			return matricula;
		}
		else {
			return matricula_DEF;
		}
	}
	public static double comprobarDiametroRuedasD (double diametroRuedasD, double diametroRuedasD_DEF) {
		if (diametroRuedasD > 0.4 && diametroRuedasD < 4) {
			return diametroRuedasD;
		}
		else {
			return diametroRuedasD_DEF;
		}
	}
	public static double comprobarDiametroRuedasT (double diametroRuedasT, double diametroRuedasT_DEF) {
		if (diametroRuedasT > 0.4 && diametroRuedasT < 4) {
			return diametroRuedasT;
		}
		else {
			return diametroRuedasT_DEF;
	}
	}
	
	//Metodo para crear licencias validas
	public static Licencia crearLicencia() {
		
		//Variables
		int IDlicencia;
		String tipo;
		String nombreCompleto;
		String fechaCaducidad;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Que tipo licencia tiene esta persona? Coche, moto o camion?");
		tipo = input.nextLine();
		
		System.out.println("Cual es la fecha de caducidad de la licencia?");
		fechaCaducidad = input.nextLine();

		//Generamos el nombre de la licencia en funcion del tipo
		switch (tipo.toLowerCase()) {
			case "coche":
				nombreCompleto = "Licencia de conductor de coche (turismo)";
				break;
			case "moto":
				nombreCompleto = "Licencia de conductor de moto";
				break;
			case "camion":
				nombreCompleto = "Licencia de conductor de camion";
				break;
			default:
				nombreCompleto = "Licencia no valida";		//Se tiene que añadir un control de excepciones aqui	
		}
			
		System.out.println("ID de la licencia:");
		IDlicencia = input.nextInt();
		input.nextLine();
		
		Licencia licencia = new Licencia(IDlicencia, tipo, nombreCompleto, fechaCaducidad);
		
		return licencia;
		
	}
	
	//Metodo de captura de datos persona en bucle
	public static ArrayList<Persona> CapturaDatosPersonas () {
		
		//Variables y objetos
		String nombre, apellidos, fechaNacimiento;
		Scanner input = new Scanner (System.in);
		ArrayList<Persona> listaTitulares = new ArrayList<Persona>();
		boolean masPersonas = true;
		boolean titular;
		boolean seguro = true, garaje = true;
		
		do {
			
			titular = false;
			
			//Captura datos por pantalla
			System.out.println("Los datos que va a introducir pertenecen a un conductor o al titular de un vehiculo?");
			if (input.nextLine().equals("titular"))
				titular = true;
			
			System.out.println("Introduzca el nombre de la persona:");
			nombre = input.nextLine();
			
			System.out.println("Introduzca el apellido de la persona:");
			apellidos = input.nextLine();
			
			System.out.println("Introduzca la fecha de nacimiento de la persona:");
			fechaNacimiento = input.nextLine();
			
			Licencia licencia = crearLicencia();
			
			if (titular) {
				
				System.out.println("Tiene seguro? S/N");
				if (input.nextLine().equals("S"))
					seguro = true;
				else
					seguro = false;
				
				System.out.println("Tiene garaje? S/N");
				if (input.nextLine().equals("S"))
					garaje = true;
				else
					garaje = false;
				
			}
			
			//Creamos los objetos y los guardamos en el ArrayList
			if (titular) {
				Titular t = new Titular(nombre, apellidos, fechaNacimiento, licencia, seguro, garaje);
				listaTitulares.add(t);
			}	
			else {
				Conductor c = new Conductor(nombre, apellidos, fechaNacimiento, licencia);
				listaTitulares.add(c);
			}
			
			//Comprobamos salida del bucle
			System.out.println("Quiere introducir más personas? (S/N)");
			if (!(input.nextLine().equals("S")))
				masPersonas = false;
				
		} while (masPersonas);
		
		return listaTitulares;
		
	}
	
	//Metodo de captura de datos vehiculo en bucle
	public static ArrayList<Vehiculo> CapturaDatosVehiculos(ArrayList<Persona> listaTitulares) {
		
		//Variables y objetos
		Titular titular = null;
		Conductor conductor = null;
		String vehiculo;
		String matricula;
		String marca;
		String color;
		String marcaRuedasDelanteras = null;
		String nombrePersona;
		double diametroRuedasDelanteras = 0;
		String marcaRuedasTraseras = null;
		double diametroRuedasTraseras = 0;
		Scanner input = new Scanner (System.in);
		ArrayList<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
		ArrayList<Persona> listaConductoresVehiculo = new ArrayList<Persona>();
		boolean masVehiculos = true, hayTitular = false, hayConductor, masConductores = true;
		
		do {
			System.out.println("Quien es el titular del vehiculo?");
			nombrePersona = input.nextLine();
			for (Persona p : listaTitulares) {
				if (p.nombre.equals(nombrePersona) && (p instanceof Titular)) {
					titular = (Titular)p;
					hayTitular = true;
					break;
				}
			}
			
			if (hayTitular)	{
				
				//Añadir conductores
				while (masConductores) {
					hayConductor = false;
					System.out.println("Quieres añadir más conductores?");
					if (input.nextLine().equals("S")) {
						System.out.println("Escribe su nombre:");
						nombrePersona = input.nextLine();
						for (Persona p : listaTitulares) {
							if (p.nombre.equals(nombrePersona)) {
								//try {
								conductor = (Conductor)p;
								//} catch
								//Hay que añadir un try-catch
								listaConductoresVehiculo.add(conductor);
								hayConductor = true;
								break;
							}
						}
						if (!hayConductor)
							System.out.println("No hay coincidencia por nombre de conductor!");
					}
						else {
							masConductores = false;	
						}
				}
				
				System.out.println("¿Qué vehículo quieres crear? Coche, moto o camion?");
				vehiculo = input.nextLine();
				System.out.println("Intoduce la matrícula del vehículo:");
				matricula = input.nextLine();
				System.out.println("Introduce la marca del vehículo:");
				marca = input.nextLine();
				System.out.println("Introduce el color del vehículo:");
				color = input.nextLine();
				
				if (vehiculo.equalsIgnoreCase("Coche")) {
					Vehiculo coche;
					Metodos.introducirDatos(input, marcaRuedasDelanteras, diametroRuedasDelanteras, marcaRuedasTraseras, diametroRuedasTraseras);
					coche = new Coche (matricula, marca, color, titular, listaConductoresVehiculo, marcaRuedasDelanteras, diametroRuedasDelanteras, marcaRuedasTraseras, diametroRuedasTraseras);
					System.out.println(coche.toString());
					listaVehiculos.add(coche);
				}
				if (vehiculo.equalsIgnoreCase("Moto")) {
					Vehiculo moto;
					Metodos.introducirDatos(input, marcaRuedasDelanteras, diametroRuedasDelanteras, marcaRuedasTraseras, diametroRuedasTraseras);
					moto = new Moto (matricula, marca, color, titular, listaConductoresVehiculo, marcaRuedasDelanteras, diametroRuedasDelanteras, marcaRuedasTraseras, diametroRuedasTraseras);
					System.out.println(moto.toString());
					listaVehiculos.add(moto);
				}
				if (vehiculo.equalsIgnoreCase("Camion")) {
					Vehiculo camion;
					Metodos.introducirDatos(input, marcaRuedasDelanteras, diametroRuedasDelanteras, marcaRuedasTraseras, diametroRuedasTraseras);
					camion = new Camion (matricula, marca, color, titular, listaConductoresVehiculo, marcaRuedasDelanteras, diametroRuedasDelanteras, marcaRuedasTraseras, diametroRuedasTraseras);
					System.out.println(camion.toString());
					listaVehiculos.add(camion);
				}
				
				//Comprobamos salida del bucle
				input.nextLine();
				System.out.println("Quiere introducir más vehiculos? (S/N)");
				if (!(input.nextLine().equals("S"))) {
					masVehiculos = false;
					hayTitular = false;
					masConductores = true;
					listaConductoresVehiculo.clear();
				}
				
			}
			else {
				System.out.println("No hay coincidencia de titular por nombre!");
				System.out.println("Quieres terminar el programa? (S/N)");
				if (input.nextLine().equals("S"))				//Por si no hay ningun titular, para que el programa no se quede en un bucle infinito
					System.exit(0);
			}
				
		} while (masVehiculos);
		
		return listaVehiculos;
		
	}
	
	//Salida de datos por pantalla
	public static void ImprimirPersonas(ArrayList<Persona> listaPersonas) {
		
		for (Persona pers : listaPersonas) {
			if (pers instanceof Titular) {
				Titular titular = (Titular)pers;
				System.out.println(titular.toString());
			}
			else {
				Conductor conductor = (Conductor)pers;
				System.out.println(conductor.toString());
			}
		}
		
	}
	public static void ImprimirVehiculos(ArrayList<Vehiculo> listaVehiculos) {
		
		for (Vehiculo vehi : listaVehiculos) {
			if (vehi instanceof Coche) {
				Coche coche = (Coche)vehi;
				System.out.println(coche.toString());
			}
			else if (vehi instanceof Moto) {
				Moto moto = (Moto)vehi;
				System.out.println(moto.toString());
			}
			else if (vehi instanceof Camion) {
				Camion camion = (Camion)vehi;
				System.out.println(camion.toString());
			}
		}
		
	}
	
}
