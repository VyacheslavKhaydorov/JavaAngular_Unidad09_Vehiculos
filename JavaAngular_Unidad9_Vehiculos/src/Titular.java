

/**
 * @author Cesar Torrelles, Ingrid Dominguez, Vyacheslav Khaydorov
 *
 */

//creamos una sub-clase  de "Persona", llamada "Titular"
public class Titular extends Persona{
	
	
	//Atributos
	protected boolean seguro;
	protected boolean garaje;

	//Constructor: en este objeto recogemos varios datos heredados de "persona" y añadimos los atributos "seguro" y "garaje"
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
	//creamos un toString de esta clase para poder imprimir los datos del Titular
	public String toString() {
		return "Titular [ nombre: " + nombre + ", apellidos: " + apellidos + ", fecha de nacimiento: " + fechaNacimiento
				+ ", licencia: " + licencia + ", seguro: " + seguro + ", garaje: " + garaje + " ]";
	}

}
