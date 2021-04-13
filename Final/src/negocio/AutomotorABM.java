package negocio;

import java.util.List;
import dao.*;
import datos.*;

public class AutomotorABM {
	private static AutomotorABM instancia = null;

	public static AutomotorABM getInstance() {
		if (instancia == null) {
			instancia = new AutomotorABM();
		}
		return instancia;
	}


	public Automotor traerAutomotor(String dominio) {
		Automotor c = AutomotorDao.getInstance().traerAutomotor(dominio);
		return c;
	}


	public Automotor traerAutomotor(int idAutomotor) throws Exception {
		Automotor c = AutomotorDao.getInstance().traerAutomotor(idAutomotor);
		if (c == null) {
			throw new Exception("Error en la capa de negocio, no existe Automotor con el id indicado");
		}
		return c;
	}

}
