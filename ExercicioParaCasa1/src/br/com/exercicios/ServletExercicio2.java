package br.com.exercicios;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletExercicio2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		buscarDados(req, resp);
		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		buscarDados(req, resp);
		
	}
	
	protected void buscarDados(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();		
		
		int numInicial = Integer.parseInt(req.getParameter("numInicial"));
		int numFinal = Integer.parseInt(req.getParameter("numFinal"));
		
		String resultado = "";
		
		if (numInicial < 0 || numFinal < 0 )
			resultado = "N�o � permitido digitar n�meros negativos."; 
		else if (numInicial == numFinal )
			resultado = "N�o � permitido digitar n�meros iguais."; 
		else if (numInicial > numFinal )
			resultado = "O n�mero inicial n�o pode ser maior que o n�mero final."; 
		else 
		{
			for (int i = numInicial; i <= numFinal; i++) {
				resultado += " " + i; 						
			}		
		}
		
		out.write(resultado);
		
	}

}
