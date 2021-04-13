package datos;

public class Persona {
	private int idPersona;
	private String apellido;
	private String nombres;
	private int dni;
	
	Persona(){}
	
	public String toString() {
		return"\nID Persona: "+idPersona+"\nNombre completo: "+apellido+", "+nombres+"\nDni: "+dni;
	}

	public Persona(String apellido, String nombres, int dni) {
		super();
		this.apellido = apellido;
		this.nombres = nombres;
		this.dni = dni;
	}

	public int getIdPersona() {
		return idPersona;
	}

	protected void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}
	
	

}
