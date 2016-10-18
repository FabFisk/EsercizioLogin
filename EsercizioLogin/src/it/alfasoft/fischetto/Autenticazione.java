package it.alfasoft.fischetto;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UtenteDAO;

/**
 * Servlet implementation class Autenticazione
 */
@WebServlet("/Autenticazione")
public class Autenticazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtenteDAO uDAO = new UtenteDAO();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		HttpSession sessione = request.getSession();
		
		if(uDAO.readUtente(username, password)){
			response.sendRedirect("benvenuto.html");
		}else{
			response.sendRedirect("login.html");
		}
	}
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String password = request.getParameter("password");
		
		if(password.equals("123")){
			RequestDispatcher rd = request.getRequestDispatcher("Redirect");
			rd.forward(request, response);
		}else{
			response.sendRedirect("login.html");
		}
	}
	

}
