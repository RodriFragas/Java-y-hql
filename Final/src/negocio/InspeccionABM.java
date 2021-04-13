package negocio;

import java.time.LocalDate;
import java.util.List;
import dao.*;
import datos.*;

public class InspeccionABM {
	private static InspeccionABM instancia = null;

	public static InspeccionABM getInstance() {
		if (instancia == null) {
			instancia = new InspeccionABM();
		}
		return instancia;
	}

	public List<Inspeccion> traerInspeccion(LocalDate desde, LocalDate hasta, String e) {
		return InspeccionDao.getInstance().traerInspeccion(desde, hasta, e);
	}

	public List<Inspeccion> traerInspeccionPorFecha(LocalDate fecha) {
		return InspeccionDao.getInstance().traerInspeccionPorFecha(fecha);
	}

	public List<Inspeccion> traerInspeccionIdAutomotor(Automotor automotor) {
		return InspeccionDao.getInstance().traerInspeccionIdAutomotor(automotor);
	}

	public List<Inspeccion> traerInspeccion9(LocalDate fecha, String estado) {
		return InspeccionDao.getInstance().traerInspeccion9(fecha, estado);
	}

	public Inspeccion traerInspeccionID(int idInspeccion) throws Exception {
		Inspeccion c = InspeccionDao.getInstance().traerInspeccionID(idInspeccion);
		if (c == null) {
			throw new Exception("Error en la capa de negocio, no existe Inspeccion con el id indicado");
		}
		return c;
	}

	public Inspeccion traerInspeccion8(Inspector inspector, LocalDate fecha) {
		Inspeccion c = InspeccionDao.getInstance().traerInspeccion8(inspector, fecha);
		return c;
	}
}
