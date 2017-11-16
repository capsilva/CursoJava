package br.com.exercicios;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletExercicio1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
				
		buscarDados(req, resp);
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		buscarDados(req, resp);
	
	}
	
	protected void buscarDados(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();		
		
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));	
		
		if (num1 > num2) 
			out.write("Num1 é maior que Num2.");
		else if (num2 > num1) 
			out.write("Num2 é maior que Num1.");
		else if (num1 == num2) 
			out.write("Num1 é igual Num2.");
		
	}
	

}
