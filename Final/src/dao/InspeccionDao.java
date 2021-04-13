package dao;

import java.time.LocalDate;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.*;

public class InspeccionDao {
	private static Session session;
	private Transaction tx;
	private static InspeccionDao instancia = null;

	public static InspeccionDao getInstance() {
		if (instancia == null) {
			instancia = new InspeccionDao();
		}
		return instancia;
	}

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos en InspeccionDao", he);
	}

	// 5)Traer inspeccion id 1
	public Inspeccion traerInspeccionID(int idInspeccion) throws HibernateException {
		Inspeccion objeto = null;
		try {
			iniciaOperacion();
			objeto = (Inspeccion) session.get(Inspeccion.class, idInspeccion);
		} finally {
			session.close();
		}
		return objeto;
	}

	// 6)Traer inspecciones del automotor con id 5
	@SuppressWarnings("unchecked")
	public List<Inspeccion> traerInspeccionIdAutomotor(Automotor automotor) throws HibernateException {
		List<Inspeccion> lista = null;

		try {
			iniciaOperacion();
			String hql = "from Inspeccion i inner join fetch i.idAutomotor a where a.idAutomotor= "
					+ automotor.getIdAutomotor();
			lista = session.createQuery(hql).list();
		} finally {
			session.close();
		}
		return lista;
	}

	// 7)Traer inspecciones del 11/2/2019

	@SuppressWarnings("unchecked")
	public List<Inspeccion> traerInspeccionPorFecha(LocalDate fecha) throws HibernateException {
		List<Inspeccion> lista = null;

		try {
			iniciaOperacion();
			String hql = "from Inspeccion i where i.fecha=:fecha";
			lista = session.createQuery(hql).setParameter("fecha", fecha).list();
		} finally {
			session.close();
		}
		return lista;
	}

	// n8)Traer inspeccion del inspector con id 1 del 11/02/2019

	public Inspeccion traerInspeccion8(Inspector inspector, LocalDate fecha) throws HibernateException {
		Inspeccion objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Inspeccion i inner join fetch i.idInspector ii where i.fecha=:fecha and i.idInspector= "
					+ inspector.getIdPersona();
			objeto = (Inspeccion) session.createQuery(hql).setParameter("fecha", fecha).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	// n9)Traer inspeccion del 11/02/2019 con estado apto

	@SuppressWarnings("unchecked")
	public List<Inspeccion> traerInspeccion9(LocalDate fecha, String estado) throws HibernateException {
		List<Inspeccion> lista = null;

		try {
			iniciaOperacion();
			String hql = "from Inspeccion i where i.fecha=:fecha and i.estado='" + estado + "'";
			// "from Inspeccion i where i.fecha=:fecha and i.estado='" + estado + "'"
			// "from Inspeccion i where i.fecha=:fecha"
			// .setParameter("estado", estado)
			lista = session.createQuery(hql).setParameter("fecha", fecha).list();
		} finally {
			session.close();
		}
		return lista;
	}

	// 10)Traer inspecciones entre fecha con estado apto
	@SuppressWarnings("unchecked")
	public List<Inspeccion> traerInspeccion(LocalDate desde, LocalDate hasta, String e) throws HibernateException {
		List<Inspeccion> lista = null;

		try {
			iniciaOperacion();
			String hql = "from Inspeccion i where i.fecha>=:desde and i.fecha<=:hasta and i.estado='" + e + "'";
			lista = session.createQuery(hql).setParameter("desde", desde).setParameter("hasta", hasta).list();

			// String hql = "from Automotor a where a.dominio= '" + dominio+"'";
			// .setParameter("e", e)
		} finally {
			session.close();
		}
		return lista;
	}

}
