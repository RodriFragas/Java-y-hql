package datos;

public class Automotor {
	private int idAutomotor;
	private String dominio;
	private int modelo;
	private String marca;
	private Contribuyente idContribuyente;

	Automotor(){}
	
	public String toString() {
		return "\nID Automotor: "+idAutomotor+"\nDominio: "+dominio+"\nModelo: "+modelo+"\nMarca: "+marca+"\nID Contribuyente: "+idContribuyente;
	}

	
	
	public Automotor(int idAutomotor, String dominio, int modelo, String marca, Contribuyente idContribuyente) {
		super();
		this.idAutomotor = idAutomotor;
		this.dominio = dominio;
		this.modelo = modelo;
		this.marca = marca;
		this.idContribuyente = idContribuyente;
	}


	public int getIdAutomotor() {
		return idAutomotor;
	}

	public void setIdAutomotor(int idAutomotor) {
		this.idAutomotor = idAutomotor;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public int getModelo() {
		return modelo;
	}

	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Contribuyente getIdContribuyente() {
		return idContribuyente;
	}

	public void setIdContribuyente(Contribuyente idContribuyente) {
		this.idContribuyente = idContribuyente;
	}
	
}

