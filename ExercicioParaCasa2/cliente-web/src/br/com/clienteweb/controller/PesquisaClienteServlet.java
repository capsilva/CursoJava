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
		String nome  = "";
		String sobreNome  = "";
		String idade  = "";
		String telefone  = "";
		String filtro = request.getParameter("txtPesquisa");

		int idCookie1 = 0;
		int idCookie2 = 0;
		int idCookie3 = 0;
		int idCookie4 = 0;
		int idCookie5 = 0;
		
		for (Cookie cookie : request.getCookies())
		{
            if (cookie.getName().equals("cookieId" + idCookie1))
            {
            	id =  cookie.getValue();
            	idCookie1 +=1;
            }
            if (cookie.getName().equals("cookieNome" + idCookie2))
            {
            	nome =  cookie.getValue();
            	idCookie2 +=1;
            }
            if (cookie.getName().equals("cookieSobrenome" + idCookie3))
            {
            	sobreNome =  cookie.getValue();
            	idCookie3 +=1;
            }
            if (cookie.getName().equals("cookieIdade" + idCookie4))
            {
            	idade =  cookie.getValue();
            	idCookie4 +=1;
            }
            if (cookie.getName().equals("cookieTelefone" + idCookie5))
            {
            	telefone =  cookie.getValue();
            	idCookie5 +=1;
            }
            if(!id.equals("") && !nome.equals("") && !sobreNome.equals("") && !idade.equals("") && !telefone.equals(""))           	
            {	
            	listaCliente.add(new Cliente(id, nome, sobreNome, Integer.parseInt(idade), telefone));            	
            }
            
		}
		 
		request.setAttribute("clientes", removerDuplicados(getCliente(filtro, listaCliente)));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	
	}
	
	private List<Cliente> removerDuplicados(List<Cliente> lista)
	{
		List<Cliente> listaCliente = new ArrayList<Cliente>(); 
		String nome = "";
		for(Cliente item : lista){
			if (!nome.equals(item.getNome()))
				listaCliente.add(item);
			nome = item.getNome();
		}
		return listaCliente;		
	}
	
	private List<Cliente> getCliente(String filtro, List<Cliente> lista)
	{
		if(filtro.equals(""))
			return lista;
		else
		{
			List<Cliente> listaCliente = new ArrayList<Cliente>();
			for(Cliente item : lista){
				if (filtro.equals(item.getNome()))
					listaCliente.add(item);
			}
			return listaCliente;	
		}
	}

}
