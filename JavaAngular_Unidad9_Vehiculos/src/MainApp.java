


import java.util.ArrayList;

/**
 * @author Cesar Torrelles, Ingrid Dominguez, Vyacheslav Khaydorov
 *
 */
public class MainApp {

	public static void main(String[] args) {
		
		// Con este metodo "CapturaDatosPersonas" introduciremos los datos de las personas 
		// y lo guardaremos en la ArrayList "Listapersonas" con el tipo de objeto "persona"  
		ArrayList<Persona> listaPersonas = Metodos.CapturaDatosPersonas();
		
		
		//En este metodo realizaremos la creacion de vehiculos y personas
		// y lo guardaremos en la ArrayList "ListaVehiculos" con el tipo de objeto "Vehiculo"
		ArrayList<Vehiculo> listaVehiculos = Metodos.CapturaDatosVehiculos(listaPersonas);
		
		
		
		//Imprimimos ambos Arraylist
		Metodos.ImprimirPersonas(listaPersonas);
		Metodos.ImprimirVehiculos(listaVehiculos);

	}

}
