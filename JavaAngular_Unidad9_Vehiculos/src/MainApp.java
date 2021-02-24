/**
 * 
 */

import java.util.ArrayList;

/**
 * @author Cesar Torrelles, Ingrid Dominguez, Vyacheslav Khaydorov
 *
 */
public class MainApp {

	public static void main(String[] args) {
		
		//Capturamos personas por teclado
		ArrayList<Persona> listaPersonas = Metodos.CapturaDatosPersonas();
		
		//Creacion de vehiculos y personas
		ArrayList<Vehiculo> listaVehiculos = Metodos.CapturaDatosVehiculos(listaPersonas);
		
		//Imprimimos ambos
		Metodos.ImprimirPersonas(listaPersonas);
		Metodos.ImprimirVehiculos(listaVehiculos);

	}

}
