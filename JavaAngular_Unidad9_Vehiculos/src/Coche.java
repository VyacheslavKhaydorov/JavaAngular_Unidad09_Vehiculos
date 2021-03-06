
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Cesar Torrelles, Ingrid Dominguez, Vyacheslav Khaydorov
 *
 */

//creamos otra sub-clase de "vehiculo" llamada "Coche"
public class Coche extends Vehiculo {
	
	
	//Atributos
	protected String marcaRuedasD;
	protected double diametroRuedasD;
	protected String marcaRuedasT;
	protected double diametroRuedasT; 
	
	//Constantes, diametros por defecto
	protected double diametroRuedasD_DEF = 0.5;
	protected double diametroRuedasT_DEF = 0.5;
	
	//Constructor
	public Coche(String matricula, String marca, String color, Titular titular, ArrayList<Persona> listaConductoresVehiculo, String marcaRuedasD, double diametroRuedasD, String marcaRuedasT, double diametroRuedasT) {
		super(matricula, marca, color, titular, listaConductoresVehiculo);
		this.marcaRuedasD = marcaRuedasD;
		this.marcaRuedasT = marcaRuedasT;
		//en el constructor "diametroRuedasD" y "diametroRuedasT" comprobaremos si el diametro se encuentra dentro de los margenes establecidos
		// en caso contrario se asignara un diametro por defecto
		this.diametroRuedasD = Metodos.comprobarDiametroRuedasD(diametroRuedasD, diametroRuedasD_DEF);
		this.diametroRuedasT = Metodos.comprobarDiametroRuedasT(diametroRuedasT, diametroRuedasT_DEF);
	}

	//Getters y setters
	public String getMarcaRuedasD() {
		return marcaRuedasD;
	}

	public void setMarcaRuedasD(String marcaRuedasD) {
		this.marcaRuedasD = marcaRuedasD;
	}

	public double getDiametroRuedasD() {
		return diametroRuedasD;
	}

	public void setDiametroRuedasD(double diametroRuedasD) {
		this.diametroRuedasD = diametroRuedasD;
	}

	public String getMarcaRuedasT() {
		return marcaRuedasT;
	}

	public void setMarcaRuedasT(String marcaRuedasT) {
		this.marcaRuedasT = marcaRuedasT;
	}

	public double getDiametroRuedasT() {
		return diametroRuedasT;
	}

	public void setDiametroRuedasT(double diametroRuedasT) {
		this.diametroRuedasT = diametroRuedasT;
	}

	@Override
	//creamos un toString de esta clase para poder imprimir los datos en el objeto "Coche"
	public String toString() {
		return "Coche [ Matricula: " + getMatricula() + ", Marca: " + getMarca() + ", Color: " + getColor() + "\n" + titular
				+ "\nmarcaRuedasD: " + marcaRuedasD + ", diametroRuedasD: "
				+ diametroRuedasD + ", marcaRuedasT: " + marcaRuedasT + ", diametroRuedasT: " + diametroRuedasT
				+ " ]";
	}

	
}
