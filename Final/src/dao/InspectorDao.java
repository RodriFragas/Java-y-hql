package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.*;

public class InspectorDao {
	private static Session session;
	private Transaction tx;
	private static InspectorDao instancia = null;

	public static InspectorDao getInstance() {
		if (instancia == null) {
			instancia = new InspectorDao();
		}
		return instancia;
	}

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos en InspectorDao", he);
	}

	public Inspector traerInspector(int idInspector) throws HibernateException {
		Inspector objeto = null;
		try {
			iniciaOperacion();
			objeto = (Inspector) session.get(Inspector.class, idInspector);
		} finally {
			session.close();
		}
		return objeto;
	}

	@SuppressWarnings("unchecked")
	public List<Inspector> traerInspector() throws HibernateException {
		List<Inspector> lista = null;
		try {
			iniciaOperacion();
			String hql = "from Inspector";
			lista = session.createQuery(hql).list();
		} finally {
			session.close();
		}
		return lista;
	}

}
