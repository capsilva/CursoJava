package br.com.exercicios;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class laco1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
           
    public laco1() {
        super();       
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		

		int num1 = Integer.parseInt(req.getParameter("x"));
		int num2 = Integer.parseInt(req.getParameter("y"));

		PrintWriter writer = resp.getWriter();
		String resultado = null;
		
		for(int i = num1; i < num2; i++ )
		{
			resultado += i;
		}
		
		writer.write(resultado);
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			
		
	}

}
