package dao;

import model.Utente;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utility.HibernateUtil;

public class UtenteDAO {

	//1- Create
	public void createUtente(String nome, String cognome, String mail,
			String user, String psw) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		Utente u = new Utente(nome, cognome, mail, user, psw);
		try {
			tx = session.getTransaction();
			tx.begin();
			session.persist(u);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}		
	}
	//2- Read
	public boolean readUtente(String user, String psw){
		boolean token = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from Utente where username=:nomeInserito and password=:cognomeInserito ");
			query.setString("userInserito", user);
			query.setString("pswInserito", psw);
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
