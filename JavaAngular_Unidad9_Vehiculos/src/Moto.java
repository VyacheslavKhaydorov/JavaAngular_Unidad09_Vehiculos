import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Cesar Torrelles, Ingrid Dominguez, Vyacheslav Khaydorov
 *
 */
public class Moto extends Vehiculo {
	//Atributos
	protected String marcaRuedaD;
	protected double diametroRuedaD;
	protected String marcaRuedaT;
	protected double diametroRuedaT; 
	
	//Constantes
	protected double diametroRuedaD_DEF = 0;
	protected double diametroRuedaT_DEF = 0;
	
	//Constructor
	public Moto(String matricula, String marca, String color, Titular titular, ArrayList<Persona> listaConductoresVehiculo, String marcaRuedasD, double diametroRuedaD, String marcaRuedaT, double diametroRuedaT) {
		super(matricula, marca, color, titular, listaConductoresVehiculo);
		this.marcaRuedaD = marcaRuedasD;
		this.diametroRuedaD = Metodos.comprobarDiametroRuedasD(diametroRuedaD, diametroRuedaD_DEF);;
		this.marcaRuedaT = marcaRuedaT;
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
	public String toString() {
		return "Moto [Matricula=" + getMatricula() + ", Marca=" + getMarca() + ", Color=" + getColor() + "\n" + titular
				+ "\nmarcaRuedasD=" + marcaRuedaD + ", diametroRuedasD="
				+ diametroRuedaD + ", marcaRuedasT=" + marcaRuedaT + ", diametroRuedasT=" + diametroRuedaT + "]";
	}

	
}
