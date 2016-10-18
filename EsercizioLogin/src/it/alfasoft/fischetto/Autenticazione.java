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
 * Servlet implementation class Autenticazione
 */
@WebServlet("/Autenticazione")
public class Autenticazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Servizi s = new Servizi();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(s.controllaCredenziali(username, password)){
			PrintWriter wr = response.getWriter();
			wr.println("Login eseguito:"+"</br>");
			RequestDispatcher rd = request.getRequestDispatcher("Redirect");
			rd.include(request, response);
		}else{
			RequestDispatcher rd2 = request.getRequestDispatcher("login.html");
			PrintWriter wr = response.getWriter();
			wr.println("Username o Password errata!");
			rd2.include(request, response);
		}
	}
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String password = request.getParameter("password");
		
		if(password.equals("123")){
			PrintWriter wr = response.getWriter();
			wr.println("Login eseguito:"+"</br>");
			RequestDispatcher rd = request.getRequestDispatcher("Redirect");
			rd.include(request, response);
		}else{
			//response.sendRedirect("login.html");
			RequestDispatcher rd2 = request.getRequestDispatcher("login.html");
			PrintWriter wr = response.getWriter();
			wr.println("Username o Password errata!");
			rd2.include(request, response);
		}
	}
	

}
