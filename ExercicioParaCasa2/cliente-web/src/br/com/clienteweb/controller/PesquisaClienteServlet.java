package br.com.clienteweb.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cliente.model.Cliente;

public class PesquisaClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PesquisaClienteServlet() {
        super();        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		pesquisarCliente(request, response);
	}
	
	private void pesquisarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		List<Cliente> listaCliente = new ArrayList<Cliente>(); 
				
		String id = "";
		String nome = "";
		String sobreNome = "";
		String idade = "0";
		String telefone = "";
		
		for (Cookie cookie : request.getCookies())
		{
            if (cookie.getName().equals("cookieId"))
            	id =  cookie.getValue();
            if (cookie.getName().equals("cookieNome"))
            	nome =  cookie.getValue();
            if (cookie.getName().equals("cookieSobrenome"))
            	sobreNome =  cookie.getValue();
            if (cookie.getName().equals("cookieIdade"))
            	idade =  cookie.getValue();
            if (cookie.getName().equals("cookieTelefone"))
            	telefone =  cookie.getValue();            
            listaCliente.add(new Cliente(id, nome, sobreNome, Integer.parseInt(idade), telefone));
		}
		
		request.setAttribute("clientes", listaCliente);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	
	}

}
