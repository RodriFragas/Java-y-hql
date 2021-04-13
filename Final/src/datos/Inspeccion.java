package datos;

import java.time.LocalDate;

import funciones.Funciones;

public class Inspeccion {
	private int idInspeccion;
	private LocalDate fecha;
	private boolean estadoPagado;
	private String estado;
	private Automotor idAutomotor;
	private Inspector idInspector;

	Inspeccion(){}
	
	public String toString() {
		return "\nID Inspeccion: "+idInspeccion+"\nFecha: "+Funciones.traerFechaCorta(fecha)+"\nEstado pagado: "+estadoPagado+"\nEstado: "+estado+"\n\nDatos del Automotor: "
				+idAutomotor+"\n\nDatos del Inspector: "+idInspector;
		}

	public Inspeccion(LocalDate fecha, boolean estadoPagado, String estado, Automotor idAutomotor,
			Inspector idInspector) {
		super();
		this.fecha = fecha;
		this.estadoPagado = estadoPagado;
		this.estado = estado;
		this.idAutomotor = idAutomotor;
		this.idInspector = idInspector;
	}

	public int getIdInspeccion() {
		return idInspeccion;
	}

	protected void setIdInspeccion(int idInspeccion) {
		this.idInspeccion = idInspeccion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public boolean isEstadoPagado() {
		return estadoPagado;
	}

	public void setEstadoPagado(boolean estadoPagado) {
		this.estadoPagado = estadoPagado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Automotor getIdAutomotor() {
		return idAutomotor;
	}

	public void setIdAutomotor(Automotor idAutomotor) {
		this.idAutomotor = idAutomotor;
	}

	public Inspector getIdInspector() {
		return idInspector;
	}

	public void setIdInspector(Inspector idInspector) {
		this.idInspector = idInspector;
	}

	
	
	
}
