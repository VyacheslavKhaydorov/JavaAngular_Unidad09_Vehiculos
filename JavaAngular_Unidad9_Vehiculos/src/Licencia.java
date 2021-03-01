

/**
 * @author Cesar Torrelles, Ingrid Dominguez, Vyacheslav Khaydorov
 *
 */

//creamos una clase llamada "licencia" para almacenar los datos de las licencias de los conductores
public class Licencia {
	
	//Atributos
	protected int IDlicencia;
	protected String tipo;
	protected String nombreCompleto;
	protected String fechaCaducidad;
	
	
	//Constructor
	public Licencia(int IDlicencia, String tipo, String nombreCompleto, String fechaCaducidad) {
		this.IDlicencia = IDlicencia;
		this.tipo = tipo;
		this.nombreCompleto = nombreCompleto;
		this.fechaCaducidad = fechaCaducidad;
	}

	//Getters y setters
	public int getID() {
		return IDlicencia;
	}

	public void setID(int IDlicencia) {
		this.IDlicencia = IDlicencia;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	@Override
	//creamos un toString de esta clase para poder imprimir los datos de la Licencia
	public String toString() {
		return "Licencia [ID=" + IDlicencia + ", tipo=" + tipo + ", nombreCompleto=" + nombreCompleto + ", fechaCaducidad="
				+ fechaCaducidad + "]";
	}
	
	

}
