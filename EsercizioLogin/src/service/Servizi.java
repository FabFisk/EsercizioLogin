package service;

import dao.UtenteDAO;

public class Servizi {

	UtenteDAO uDAO = new UtenteDAO();
	
	public boolean controllaCredenziali(String user, String psw){
		return uDAO.readUtente(user, psw);
	}
}
