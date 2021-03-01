

/**
 * @author Cesar Torrelles, Ingrid Dominguez, Vyacheslav Khaydorov
 *
 */

//creamos una super clase llamada Persona 

public class Persona {
	
	
	//Añadimos sus Atributos
	public String nombre;
	protected String apellidos;
	protected String fechaNacimiento;
	protected String licencia;
	
	//Añadimos el Constructor
	public Persona(String nombre, String apellidos, String fechaNacimiento, Licencia licencia) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.licencia = licencia.nombreCompleto;
	}

}
