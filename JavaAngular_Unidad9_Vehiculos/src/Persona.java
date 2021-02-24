/**
 * 
 */

/**
 * @author Cesar Torrelles, Ingrid Dominguez, Vyacheslav Khaydorov
 *
 */
public class Persona {
	//Atributos
	protected String nombre;
	protected String apellidos;
	protected String fechaNacimiento;
	protected String licencia;
	
	//Constructor
	public Persona(String nombre, String apellidos, String fechaNacimiento, Licencia licencia) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.licencia = licencia.nombreCompleto;
	}

}
