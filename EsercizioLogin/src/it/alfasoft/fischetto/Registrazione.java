package it.alfasoft.fischetto;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Servizi;

/**
 * Servlet implementation class Registrazione
 */
@WebServlet("/Registrazione")
public class Registrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Servizi s = new Servizi();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int antispam = request.getIntHeader("antispam");
		String psw1 = request.getParameter("password1");
		String psw2 = request.getParameter("password2");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String user = request.getParameter("username");
		String mail = request.getParameter("mail");
		
		if(antispam==4){
			if(psw1.equals(psw2)){
				s.registraUtente(nome, cognome, mail, user, psw1);
			}else{
				RequestDispatcher rd2 = request.getRequestDispatcher("login.html");
				PrintWriter wr = response.getWriter();
				wr.println("Le password non coincide!");
				rd2.include(request, response);
			}
		}else{
			RequestDispatcher rd2 = request.getRequestDispatcher("login.html");
			PrintWriter wr = response.getWriter();
			wr.println("Dimostrami che non sei un robot!");
			rd2.include(request, response);
		}
	}

}
