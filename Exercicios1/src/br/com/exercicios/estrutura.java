package br.com.exercicios;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class estrutura extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public estrutura() {
       
    }
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int num1 = Integer.parseInt(req.getParameter("x"));
		int num2 = Integer.parseInt(req.getParameter("x"));

		PrintWriter writer = resp.getWriter();
			
		if(num1 > num2)
			writer.write("X é maior que Y.");
		else if(num2 > num1)
			writer.write("Y é maior que X.");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
