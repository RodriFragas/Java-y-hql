package datos;

public class Contribuyente extends Persona{
	private boolean esExcento;
	
	Contribuyente(){}
	
	public String toString() {
		return super.toString()+"\nEs excento: "+esExcento;
	}

	public Contribuyente(String apellido, String nombres, int dni, int idContribuyente, boolean esExcento) {
		super(apellido, nombres, dni);
		//this.idContribuyente = idContribuyente;
		this.esExcento = esExcento;
	}

	/*public int getIdContribuyente() {
		return idContribuyente;
	}

	public void setIdContribuyente(int idContribuyente) {
		this.idContribuyente = idContribuyente;
	}*/

	public boolean isEsExcento() {
		return esExcento;
	}

	public void setEsExcento(boolean esExcento) {
		this.esExcento = esExcento;
	}

	
	

}
