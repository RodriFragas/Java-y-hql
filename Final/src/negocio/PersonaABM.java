package negocio;

import java.util.List;
import dao.*;
import datos.*;

public class PersonaABM {
	private static PersonaABM instancia = null;

	public static PersonaABM getInstance() {
		if (instancia == null) {
			instancia = new PersonaABM();
		}
		return instancia;
	}

	public Persona traerPersona(int idPersona) throws Exception {
		Persona c = PersonaDao.getInstance().traerPersona(idPersona);
		if (c == null) {
			throw new Exception("Error en la capa de negocio, no existe Persona con el id indicado");
		}
		return c;
	}

}
