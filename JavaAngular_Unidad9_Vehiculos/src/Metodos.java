

import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author Cesar Torrelles, Ingrid Dominguez, Vyacheslav Khaydorov
 *
 */
public class Metodos {

	// METODO COMPROBACION DE MATRICULA
	public static String comprobarMatricula(String matricula, String matricula_DEF) {

		// Si la matricula introducida coincide con el formato deseado, retorna esos
		// datos
		if (matricula.toUpperCase().matches("^[0-9]{4}[A-Z]{3}$")) {
			return matricula;
		}
		// en caso de que no coincida se añade una matricula por defecto
		else {
			return matricula_DEF;
		}
	}

	// METODO COMPROBACION DIAMETRO RUEDAS DELANTERAS. Metodo que usaremos para
	// comprobar el diametro de las ruedas delanteras se
	// encuentra dentro de los margenes
	public static double comprobarDiametroRuedasD(double diametroRuedasD, double diametroRuedasD_DEF) {
		if (diametroRuedasD > 0.4 && diametroRuedasD < 4) {
			return diametroRuedasD;
		}
		// en caso contrario añadimos un diametro por defecto que se encuentra
		// registrado en cada objeto
		else {
			return diametroRuedasD_DEF;
		}
	}

	// METODO COMPROBACION DIAMETRO RUEDAS TRASERAS. Metodo que usaremos para
	// comprobar el diametro de las ruedas traseras se
	// encuentra dentro de los margenes
	public static double comprobarDiametroRuedasT(double diametroRuedasT, double diametroRuedasT_DEF) {
		if (diametroRuedasT > 0.4 && diametroRuedasT < 4) {
			return diametroRuedasT;
		} else {
			return diametroRuedasT_DEF;
		}
	}

	// METODO LICENCIAS. para crear licencias validas a partir del objeto "Licencia"
	public static Licencia crearLicencia() {

		// Variables
		int IDlicencia;
		String tipo;
		String nombreCompleto;
		String fechaCaducidad;
		Scanner input = new Scanner(System.in);

		// preguntamos el tipo de licencia
		System.out.println("Que tipo licencia tiene esta persona? Coche, moto o camion?");
		tipo = input.nextLine();

		// Generamos la licencia en funcion del tipo
		switch (tipo.toLowerCase()) {
		case "coche":
			nombreCompleto = "Conductor de coche (turismo)";
			break;
		case "moto":
			nombreCompleto = "Conductor de moto";
			break;
		case "camion":
			nombreCompleto = "Conductor de camion";
			break;
		default:
			nombreCompleto = "tipo de licencia no valida";
		}

		// preguntamos su fecha de caducidad
		System.out.println("Cual es la fecha de caducidad de la licencia?");
		fechaCaducidad = input.nextLine();

		// pedimos el ID de la licencia
		System.out.println("Introduce el ID de la licencia, ha de contener valores numericos");

		IDlicencia = input.nextInt();
		input.nextLine();

		// lo introducimos en un objeto tipo licencia
		Licencia licencia = new Licencia(IDlicencia, tipo, nombreCompleto, fechaCaducidad);

		return licencia;

	}

	// METODO DATOS PERSONA. metodo para realizar la captura de datos de una
	// persona, guardaremos los
	// datos en un arraylist de objeto tipo "persona"
	public static ArrayList<Persona> CapturaDatosPersonas() {

		// creamos las siguientes Variables y objetos
		String nombre, apellidos, fechaNacimiento;
		Scanner input = new Scanner(System.in);
		ArrayList<Persona> listaTitulares = new ArrayList<Persona>();
		boolean masPersonas = true;
		boolean titular;
		boolean seguro = true, garaje = true;

		// aplicaremos un do while
		do {

			// indicamos por defecto que no hay titular
			titular = false;

			Boolean respuestaErronea = true;
			while (respuestaErronea) {
				// preguntamos al usuario si se trata de un titular de vehiculo
				System.out.println(
						"Los datos que va a introducir pertenecen a un conductor o al titular de un vehiculo? escribe titular o conductor:");

				String respuesta = input.nextLine().toLowerCase();

				switch (respuesta) {
				case "titular":
					titular = true;
					respuestaErronea = false;
					break;

				case "conductor":
					titular = false;
					respuestaErronea = false;
					break;

				default:
					System.out.println("has de introducir: titular o conductor");
				}
			}

			// solicitamos el nombre de la persona
			System.out.println("Introduzca el nombre de la persona:");
			nombre = input.nextLine();

			// solicitamos el apellido de la persona
			System.out.println("Introduzca el apellido de la persona:");
			apellidos = input.nextLine();

			// solicitamos la fecha de nacimiento
			System.out.println("Introduzca la fecha de nacimiento de la persona:");
			fechaNacimiento = input.nextLine();

			// creamos un objeto "licencia" llamando al metodo "crear licencia"
			Licencia licencia = crearLicencia();

			// si los datos introducidos pertenecen al titular se preguntara si tiene
			// seguro, y si tiene garaje
			if (titular) {

				System.out.println("Tiene seguro? S/N");
				if (input.nextLine().equalsIgnoreCase("S"))
					seguro = true;
				else
					seguro = false;

				System.out.println("Tiene garaje? S/N");
				if (input.nextLine().equalsIgnoreCase("S"))
					garaje = true;
				else
					garaje = false;

			}

			// Creamos los objetos y los guardamos en el ArrayList

			// en caso de que sea titular lo guardamos en "titular"
			if (titular) {
				Titular t = new Titular(nombre, apellidos, fechaNacimiento, licencia, seguro, garaje);
				listaTitulares.add(t);

				// en caso de que sea solo conductor lo guardamos en "conductor"
			} else {
				Conductor c = new Conductor(nombre, apellidos, fechaNacimiento, licencia);
				listaTitulares.add(c);
			}

			// consultamos si el usuario desea inrtroducir mas personas
			System.out.println("Quiere introducir mas personas? (S/N)");

			if (!(input.nextLine().equalsIgnoreCase("S")))
				masPersonas = false;

			// si la variable "masPersonas" es cierto repetimos el bucle para volver a
			// introducir los datos de la nueva persona
		} while (masPersonas);

		// retornamos los valores en el arraylist "listaTitulares"
		return listaTitulares;

	}

	// METODO CAPTURA DATOS VEHICULO. metodo para realizar la captura de datos de
	// los vehiculos
	public static ArrayList<Vehiculo> CapturaDatosVehiculos(ArrayList<Persona> listaTitulares) {

		// creamos las siguientes Variables y arraylist
		Titular titular = null;
		Conductor conductor = null;
		String vehiculo;
		String matricula;
		String marca;
		String color;
		double diametroRuedasDelanteras = 0;
		double diametroRuedasTraseras = 0;
		String marcaRuedasDelanteras = null;
		String marcaRuedasTraseras = null;
		String nombrePersona;

		Scanner input = new Scanner(System.in);
		ArrayList<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
		ArrayList<Persona> listaConductoresVehiculo = new ArrayList<Persona>();
		boolean masVehiculos = true, hayTitular = false, hayConductor, masConductores = true;

		// creamos un bucle do while para recopilar todos los datos y permitir
		// introducir mas
		do {

			// preguntamos por el titual del vehiculo
			System.out.println("Introduccion de mas valores: Quien es el titular del vehiculo?");
			nombrePersona = input.nextLine();
			for (Persona p : listaTitulares) {
				if (p.nombre.equals(nombrePersona) && (p instanceof Titular)) {
					// si el nombre introducido coincide con un titular almacenado
					// salimos del bucle
					titular = (Titular) p;
					hayTitular = true;
					break;
				}
			}

			// en caso de que exista el titular introducido
			if (hayTitular) {

				// preguntamos si se desea añadir mas conductores
				while (masConductores) {
					hayConductor = false;
					System.out.println("Quieres añadir mas conductores? (S/N)");
					if (input.nextLine().equalsIgnoreCase("S")) {

						// solicitamos que introduzca el nombre del nuevo conductor
						System.out.println("Escribe su nombre:");
						nombrePersona = input.nextLine();
						for (Persona p : listaTitulares) {
							if (p.nombre.equals(nombrePersona)) {

								conductor = (Conductor) p;

								listaConductoresVehiculo.add(conductor);
								hayConductor = true;
								break;
							}
						}

						// si no coincide el conductor introducido con el que se encuentra guardado
						if (!hayConductor)
							// imprimimos un comunicado
							System.out.println("No hay coincidencia por nombre de conductor!");

						// en caso contrario cambiamos la variable masConductores a false
					} else {
						masConductores = false;
					}
				}

				// preguntamos al usuario que vehiculo desea crear
				System.out.println("A Que tipo de vehiculo deseas introducir los datos ? Coche, moto o camion?");
				vehiculo = input.nextLine();

				// solicitamos introducir la matricula del vehiculo
				System.out.println("Intoduce la matricula del vehiculo:");
				matricula = input.nextLine();

				// solicitamos introducir la marca del vehiculo
				System.out.println("Introduce la marca del vehiculo:");
				marca = input.nextLine();

				// solicitamos introducir el color del vehiculo
				System.out.println("Introduce el color del vehiculo:");
				color = input.nextLine();

				// si se desea crear un coche:
				if (vehiculo.equalsIgnoreCase("Coche")) {
					Vehiculo coche;

					System.out.println("introduce la marca de las ruedas delanteras");
					marcaRuedasDelanteras = input.nextLine();

					System.out.println("introduce el diametro de las ruedas delanteras");
					diametroRuedasDelanteras = input.nextDouble();

					System.out.println("introduce la marca de las ruedas traseras");
					marcaRuedasTraseras = input.nextLine();

					System.out.println("introduce el diametro de las ruedas traseras");
					diametroRuedasTraseras = input.nextDouble();

					// luego almacenaremos todos los datos en un objeto tipo "coche"
					coche = new Coche(matricula, marca, color, titular, listaConductoresVehiculo, marcaRuedasDelanteras,
							diametroRuedasDelanteras, marcaRuedasTraseras, diametroRuedasTraseras);

					// llamamos al toString del objeto
					// System.out.println(coche.toString());

					// y guardaremos los datos en la lista de vehiculos
					listaVehiculos.add(coche);
				}

				// si se desea crear una moto:
				if (vehiculo.equalsIgnoreCase("Moto")) {
					Vehiculo moto;

					System.out.println("introduce la marca de las ruedas delanteras");
					marcaRuedasDelanteras = input.nextLine();

					System.out.println("introduce el diametro de las ruedas delanteras");
					diametroRuedasDelanteras = input.nextDouble();

					System.out.println("introduce la marca de las ruedas traseras");
					marcaRuedasTraseras = input.nextLine();

					System.out.println("introduce el diametro de las ruedas traseras");
					diametroRuedasTraseras = input.nextDouble();

					// luego almacenaremos todos los datos en un objeto tipo "moto"
					moto = new Moto(matricula, marca, color, titular, listaConductoresVehiculo, marcaRuedasDelanteras,
							diametroRuedasDelanteras, marcaRuedasTraseras, diametroRuedasTraseras);
					// llamamos al toString del objeto
					// System.out.println(moto.toString());
					// y guardaremos los datos en la lista de vehiculos
					listaVehiculos.add(moto);
				}
				// si se desea crear un camion:
				if (vehiculo.equalsIgnoreCase("Camion")) {
					Vehiculo camion;

					System.out.println("introduce la marca de las ruedas delanteras");
					marcaRuedasDelanteras = input.nextLine();

					System.out.println("introduce el diametro de las ruedas delanteras");
					diametroRuedasDelanteras = input.nextDouble();

					System.out.println("introduce la marca de las ruedas traseras");
					marcaRuedasTraseras = input.nextLine();

					System.out.println("introduce el diametro de las ruedas traseras");
					diametroRuedasTraseras = input.nextDouble();

					// luego almacenaremos todos los datos en un objeto tipo "camion"
					camion = new Camion(matricula, marca, color, titular, listaConductoresVehiculo,
							marcaRuedasDelanteras, diametroRuedasDelanteras, marcaRuedasTraseras,
							diametroRuedasTraseras);
					// llamamos al toString del objeto
					// System.out.println(camion.toString());

					// y guardaremos los datos en la lista de vehiculos
					listaVehiculos.add(camion);
				}

				// Comprobamos que no se desean introducir mas datos para salir del bucle
				input.nextLine();
				System.out.println("Quiere introducir datos en otros  vehiculos? (S/N)");
				if (!(input.nextLine().equalsIgnoreCase("S"))) {
					masVehiculos = false;
					hayTitular = false;
					masConductores = true;
					listaConductoresVehiculo.clear();
				}

				// en caso de que no exista el titular introducido, indicamos si quiere terminar
				// el programa
			} else {
				System.out.println("No hay coincidencia de titular por nombre!");
				System.out.println("Quieres terminar el programa? (S/N)");
				if (input.nextLine().equalsIgnoreCase("S"))

					System.exit(0);
			}

			// mientras se deseen introducir mas vehiculos el bucle continua
		} while (masVehiculos);

		// retornamos el array con la lista de los vehiculos
		return listaVehiculos;

	}

	// Metodo con las salidas de datos de la lista de personas
	public static void ImprimirPersonas(ArrayList<Persona> listaPersonas) {

		// creamos un loop para recorrer el array "listaPersonas"
		for (Persona pers : listaPersonas) {

			System.out.println("");
			System.out.println("Persona: ");

			if (pers instanceof Titular) {
				Titular titular = (Titular) pers;
				// si coincide con el titular llamamos al metodo toString del titular para
				// imprimir los datos de este
				System.out.println(titular.toString());

				// en caso contrario realizamos la impresion del conductor
			} else {
				Conductor conductor = (Conductor) pers;
				System.out.println(conductor.toString());
			}
		}

	}

	// metodo con las salidas de datos de la lista de vehiculos
	public static void ImprimirVehiculos(ArrayList<Vehiculo> listaVehiculos) {

		// creamos un loop para recorrer el array "listaVehiculos"
		for (Vehiculo vehi : listaVehiculos) {

			System.out.println("");
			System.out.println("Lista de datos sobre los Vehiculos: ");

			// si coincide con un objeto tipo coche mandamos a imprimir los datos de ese
			// objeto con su metodo toString
			if (vehi instanceof Coche) {
				Coche coche = (Coche) vehi;
				System.out.println(coche.toString());

				// si coincide con un objeto tipo moto mandamos a imprimir los datos de ese
				// objeto con su metodo toString
			} else if (vehi instanceof Moto) {
				Moto moto = (Moto) vehi;
				System.out.println(moto.toString());

				// si coincide con un objeto tipo camion mandamos a imprimir los datos de ese
				// objeto con su metodo toString
			} else if (vehi instanceof Camion) {
				Camion camion = (Camion) vehi;
				System.out.println(camion.toString());
			}
		}

	}

}
