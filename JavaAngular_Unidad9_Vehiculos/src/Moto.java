
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Cesar Torrelles, Ingrid Dominguez, Vyacheslav Khaydorov
 *
 */

//creamos otra sub-clase de "vehiculo" llamada "Moto"
public class Moto extends Vehiculo {
	
	
	//Atributos
	protected String marcaRuedaD;
	protected double diametroRuedaD;
	protected String marcaRuedaT;
	protected double diametroRuedaT; 
	
	//Constantes, diametros por defecto
	protected double diametroRuedaD_DEF = 0.5;
	protected double diametroRuedaT_DEF = 0.5;
	
	//Constructor
	public Moto(String matricula, String marca, String color, Titular titular, ArrayList<Persona> listaConductoresVehiculo, String marcaRuedasD, double diametroRuedaD, String marcaRuedaT, double diametroRuedaT) {
		super(matricula, marca, color, titular, listaConductoresVehiculo);
		this.marcaRuedaD = marcaRuedasD;
		this.marcaRuedaT = marcaRuedaT;
		//en el constructor "diametroRuedasD" y "diametroRuedasT" comprobaremos si el diametro se encuentra dentro de los margenes establecidos
		// en caso contrario se asignara un diametro por defecto
		this.diametroRuedaD = Metodos.comprobarDiametroRuedasD(diametroRuedaD, diametroRuedaD_DEF);
		this.diametroRuedaT = Metodos.comprobarDiametroRuedasT(diametroRuedaT, diametroRuedaT_DEF);
	}

	//Getters y setters
	public String getMarcaRuedasD() {
		return marcaRuedaD;
	}

	public void setMarcaRuedasD(String marcaRuedasD) {
		this.marcaRuedaD = marcaRuedasD;
	}

	public double getDiametroRuedasD() {
		return diametroRuedaD;
	}

	public void setDiametroRuedasD(double diametroRuedasD) {
		this.diametroRuedaD = diametroRuedasD;
	}

	public String getMarcaRuedasT() {
		return marcaRuedaT;
	}

	public void setMarcaRuedasT(String marcaRuedasT) {
		this.marcaRuedaT = marcaRuedasT;
	}

	public double getDiametroRuedasT() {
		return diametroRuedaT;
	}

	public void setDiametroRuedasT(double diametroRuedasT) {
		this.diametroRuedaT = diametroRuedasT;
	}

	@Override
	//creamos un toString de esta clase para poder imprimir los datos en el objeto "Coche"
	public String toString() {
		return "Moto [ Matricula: " + getMatricula() + ", Marca: " + getMarca() + ", Color: " + getColor() + "\n" + titular
				+ "\nmarcaRuedasD: " + marcaRuedaD + ", diametroRuedasD: "
				+ diametroRuedaD + ", marcaRuedasT: " + marcaRuedaT + ", diametroRuedasT: " + diametroRuedaT + " ]";
	}

	
}
