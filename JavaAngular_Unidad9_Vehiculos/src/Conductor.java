/**
 * 
 */

/**
 * @author Cesar Torrelles, Ingrid Dominguez, Vyacheslav Khaydorov
 *
 */
public class Conductor extends Persona{
	//Constructor
	public Conductor(String nombre, String apellidos, String fechaNacimiento, Licencia licencia) {
		super(nombre, apellidos, fechaNacimiento, licencia);
	}
	
	//toString
	@Override
	public String toString() {
		return "Conductor [nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento
				+ ", licencia=" + licencia + "]";
	}
	
}
