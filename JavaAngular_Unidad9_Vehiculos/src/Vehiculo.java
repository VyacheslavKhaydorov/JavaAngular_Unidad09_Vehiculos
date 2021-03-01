

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @author Cesar Torrelles, Ingrid Dominguez, Vyacheslav Khaydorov
 *
 */

// creamos una clase llamada "Vehiculo" para almacenar todos los datos relacionados con el vehiculo
public class Vehiculo {
	
	
	//Atributos
	protected String matricula;
	protected String marca;
	protected String color;
	//incluimos el objeto "titular" como atributo de este nuevo objeto
	protected Titular titular;
	//incluimos tambien un arraylist con objetos "persona" llamado "listaConductoresVehiculo"
	//para usarlo mas adelante como una lista de datos sobre los conductores e imprimirlo
	protected ArrayList<Persona> listaConductoresVehiculo;
	
	
	//Añadimos una Constante de la matricula por defecto
	protected String matricula_DEF = "1234ABC";
	
	
	//Constructor
	public Vehiculo(String matricula, String marca, String color, Titular titular, ArrayList<Persona> listaConductoresVehiculo) {
		this.listaConductoresVehiculo = listaConductoresVehiculo;
		this.titular = titular;
		//a la hora de introducir datos de la matricula llamaremos al metodo "comprobarMatricula" para que determine si es correcta la matricula
		this.matricula = Metodos.comprobarMatricula (matricula, matricula_DEF); 
		this.marca = marca;
		this.color = color;
	}
	
	//Getters y setters
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}


	@Override
	//creamos un toString de esta clase para poder imprimir los datos del Vehiculo
	public String toString() {
		
		//creamos un stringbuilder para pasar a string los datos del arraylist "listaConductoresVehiculo"
		// y lo guardamos en una variable para luego concatenarlo al toString
		String listaConductoresVehiculoCadena = listaConductoresVehiculo.stream().map(Object::toString)
                .collect(Collectors.joining(", "));
		
		//retornamos los valores concatenados
		return "Vehiculo [matricula=" + matricula + ", marca=" + marca + ", color=" + color + "\ntitular=" + titular + "]" 
				+ "\n" + listaConductoresVehiculoCadena;
		
	}
	

}
