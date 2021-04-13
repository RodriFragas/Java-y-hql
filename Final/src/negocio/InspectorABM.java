package negocio;

import java.util.List;
import dao.*;
import datos.*;

public class InspectorABM {
	private static InspectorABM instancia = null;

	public static InspectorABM getInstance() {
		if (instancia == null) {
			instancia = new InspectorABM();
		}
		return instancia;
	}

	public Inspector traerInspector(int idInspector) throws Exception {
		Inspector c = InspectorDao.getInstance().traerInspector(idInspector);
		if (c == null) {
			throw new Exception("Error en la capa de negocio, no existe Inspector con el id indicado");
		}
		return c;
	}

	public List<Inspector> traerInspector() {
		return InspectorDao.getInstance().traerInspector();
	}

}
