/**
 * 
 */

/**
 * @author Cesar Torrelles, Ingrid Dominguez, Vyacheslav Khaydorov
 *
 */
public class Titular extends Persona{
	//Atributos
	private boolean seguro;
	private boolean garaje;

	//Constructor
	public Titular(String nombre, String apellidos, String fechaNacimiento, Licencia licencia, boolean seguro, boolean garaje) {
		super(nombre, apellidos, fechaNacimiento, licencia);
		this.seguro = seguro;
		this.garaje = garaje;
	}
	
	//Getters y setters
	public boolean isSeguro() {
		return seguro;
	}

	public void setSeguro(boolean seguro) {
		this.seguro = seguro;
	}

	public boolean isGaraje() {
		return garaje;
	}

	public void setGaraje(boolean garaje) {
		this.garaje = garaje;
	}

	@Override
	public String toString() {
		return "Titular [nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento
				+ ", licencia=" + licencia + ", seguro=" + seguro + ", garaje=" + garaje + "]";
	}

}
