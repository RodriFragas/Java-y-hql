package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.*;

public class ContribuyenteDao {
	private static Session session;
	private Transaction tx;
	private static ContribuyenteDao instancia = null;

	public static ContribuyenteDao getInstance() {
		if (instancia == null) {
			instancia = new ContribuyenteDao();
		}
		return instancia;
	}

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos en ContribuyenteDao", he);
	}


	public Contribuyente traerContribuyente(int idContribuyente) throws HibernateException {
		Contribuyente objeto = null;
		try {
			iniciaOperacion();
			objeto = (Contribuyente) session.get(Contribuyente.class, idContribuyente);
		} finally {
			session.close();
		}
		return objeto;
	}

}
