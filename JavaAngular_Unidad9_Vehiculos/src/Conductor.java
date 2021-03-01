

/**
 * @author Cesar Torrelles, Ingrid Dominguez, Vyacheslav Khaydorov
 *
 */

//creamos otra sub-clase de "persona" llamada "Conductor"
public class Conductor extends Persona{
	
	
	//Constructor: esta vez usamos solo los datos heredados de la clase "persona"
	public Conductor(String nombre, String apellidos, String fechaNacimiento, Licencia licencia) {
		super(nombre, apellidos, fechaNacimiento, licencia);
	}
	
	
	@Override
	//creamos un toString de esta clase para poder  imprimir los datos del Conductor
	public String toString() {
		return "Conductor [ nombre: " + nombre + ", apellidos: " + apellidos + ", fechaNacimiento: " + fechaNacimiento
				+ ", licencia: " + licencia + " ]";
	}
	
}
