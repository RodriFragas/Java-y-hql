package datos;

public class Inspector extends Persona {
	private int legajo;

	Inspector(){}
	
	public String toString() {
		return super.toString()+"\nLegajo: "+legajo;
	}

	public Inspector(String apellido, String nombres, int dni, int idInspector, int legajo) {
		super(apellido, nombres, dni);
		//this.idInspector = idInspector;
		this.legajo = legajo;
	}

	/*public int getIdInspector() {
		return idInspector;
	}

	public void setIdInspector(int idInspector) {
		this.idInspector = idInspector;
	}*/

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	
	
}
