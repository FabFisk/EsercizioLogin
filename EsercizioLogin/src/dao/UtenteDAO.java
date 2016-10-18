package dao;

import model.Utente;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utility.HibernateUtil;

public class UtenteDAO {

	//1- Create
	//2- Read
	public boolean readUtente(String nome, String cognome){
		boolean token = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from Utente where nome=:nomeInserito and cognome=:cognomeInserito ");
			query.setString("nomeInserito", nome);
			query.setString("cognomeInserito", cognome);
			Utente u = (Utente )query.uniqueResult();
			if(u!=null){
				token = true;
			}
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}		
		return token;
	}
}
