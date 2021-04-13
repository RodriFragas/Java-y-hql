package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.*;

public class AutomotorDao {
	private static Session session;
	private Transaction tx;
	private static AutomotorDao instancia = null; // patron singleton

	public static AutomotorDao getInstance() {
		if (instancia == null) {
			instancia = new AutomotorDao();
		}
		return instancia;
	}

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos en AutomotorDao", he);
	}

	public Automotor traerAutomotor(String dominio) throws HibernateException {
		Automotor objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Automotor a where a.dominio= '" + dominio+"'";
			objeto = (Automotor) session.createQuery(hql).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	// TRAER UN OBJETO POR CLAVE PRIMARIA(ID)

	public Automotor traerAutomotor(int idAutomotor) throws HibernateException {
		Automotor objeto = null;
		try {
			iniciaOperacion();
			objeto = (Automotor) session.get(Automotor.class, idAutomotor);
		} finally {
			session.close();
		}
		return objeto;
	}

}
