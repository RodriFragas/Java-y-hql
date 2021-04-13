package negocio;

import java.util.List;
import dao.*;
import datos.*;

public class ContribuyenteABM {
	private static ContribuyenteABM instancia = null;

	public static ContribuyenteABM getInstance() {
		if (instancia == null) {
			instancia = new ContribuyenteABM();
		}
		return instancia;
	}
	
	public Contribuyente traerContribuyenteee(int idContribuyente) throws Exception {
		Persona p = PersonaDao.getInstance().traerPersona(idContribuyente);
		Contribuyente c = null;
		if (!(p instanceof Contribuyente)) {
			throw new Exception("error en la capa de negocio, el id indicado no pertenece a un Contribuyente");
		}
		c = (Contribuyente) p;
		return c;
	}
	
	public Contribuyente traerContribuyente(int idContribuyente) throws Exception{
		Contribuyente c= ContribuyenteDao.getInstance().traerContribuyente(idContribuyente);
		if (c== null){
			throw new Exception ("Error en la capa de negocio, no existe Contribuyente con el id indicado");
		}
		return c;
	}

	

}
