package service;

import dao.UtenteDAO;

public class Servizi {

	UtenteDAO uDAO = new UtenteDAO();
	
	public boolean controllaCredenziali(String user, String psw){
		return uDAO.readUtente(user, psw);
	}

	public void registraUtente(String nome, String cognome, String mail,
			String user, String psw1) {
		uDAO.createUtente(nome, cognome, mail, user, psw1);		
	}
}
