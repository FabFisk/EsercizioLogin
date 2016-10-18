package model;

import javax.persistence.*;

@Entity
public class Utente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private long id_utente;
	private String nome;
	private String cognome;
	private String mail;
	private String username;
	private String password;
	
	public Utente(){}
	public Utente(String nome, String cognome, String mail, String user,
			String psw) {
		this.setNome(nome);
		this.setCognome(cognome);
		this.setMail(mail);
		this.username=user;
		this.password=psw;
	}
	public long getId_utente() {
		return id_utente;
	}

	public void setId_utente(long id_utente) {
		this.id_utente = id_utente;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	
	

}
