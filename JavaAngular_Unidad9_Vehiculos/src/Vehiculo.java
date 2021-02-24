/**
 * 
 */

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @author Cesar Torrelles, Ingrid Dominguez, Vyacheslav Khaydorov
 *
 */
public class Vehiculo {
	//Atributos
	protected String matricula;
	protected String marca;
	protected String color;
	protected Titular titular;
	protected ArrayList<Persona> listaConductoresVehiculo;
	
	//Constantes
	protected String matricula_DEF = "1234ABC";
	
	
	//Constructor
	public Vehiculo(String matricula, String marca, String color, Titular titular, ArrayList<Persona> listaConductoresVehiculo) {
		this.listaConductoresVehiculo = listaConductoresVehiculo;
		this.titular = titular;
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
	public String toString() {
		
		String listaConductoresVehiculoCadena = listaConductoresVehiculo.stream().map(Object::toString)
                .collect(Collectors.joining(", "));
		
		return "Vehiculo [matricula=" + matricula + ", marca=" + marca + ", color=" + color + "\ntitular=" + titular + "]" 
				+ "\n" + listaConductoresVehiculoCadena;
		
	}
	

}
