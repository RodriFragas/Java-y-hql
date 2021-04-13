package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.*;

public class PersonaDao {
	private static Session session;
	private Transaction tx;
	private static PersonaDao instancia = null; 

	public static PersonaDao getInstance() {
		if (instancia == null) {
			instancia = new PersonaDao();
		}
		return instancia;
	}

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos en PersonaDao", he);
	}

	public Persona traerPersona(int idPersona) throws HibernateException {
		Persona objeto = null;
		try {
			iniciaOperacion();
			objeto = (Persona) session.get(Persona.class, idPersona);
		} finally {
			session.close();
		}
		return objeto;
	}

}
