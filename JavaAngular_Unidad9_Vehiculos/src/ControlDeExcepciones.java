/**
 * 
 */

/**
 * @author viach
 *
 */
public class ControlDeExcepciones extends Exception{

	//Variables
	private String codigoExcepcion;
	
	//Constructores
	public ControlDeExcepciones() {
		super();
	}
		
	public ControlDeExcepciones(String error) {
		super();
		this.codigoExcepcion = error;
	}
	
	//Metodo mostrar mensaje de error
	@Override
	public String getMessage() {
		
		String mensaje = "";
		
		switch (codigoExcepcion.toLowerCase()) {
			//Error 1
			case "coche":
				mensaje = "Error 1: al parecer algo no ha salido bien!";
				break;
			//Error 2
			case "moto":
				mensaje = "Error 2: al parecer algo no ha salido bien!";
				break;
			//Error 3
			case "camion":
				mensaje = "Error 3: al parecer algo no ha salido bien!";
				break;
		}
		
		return mensaje;
		
	}

}
