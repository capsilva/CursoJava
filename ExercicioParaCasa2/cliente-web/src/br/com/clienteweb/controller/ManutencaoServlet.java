package br.com.clienteweb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cliente.dao.ClienteDao;
import br.com.cliente.model.Cliente;

public class ManutencaoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException 
	{
		salvar(request, response);
	}
	
	protected void salvar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String idCliente = request.getParameter("id");
		if (idCliente != null)
			update(idCliente, request, response);
		else
			insert(request, response);	
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = getParameter(request, "txtId");
		String nome = getParameter(request, "txtNome");
		String sobreNome = getParameter(request, "txtSobrenome");
		String idade = getParameter(request, "txtIdade");
		String telefone = getParameter(request, "txtTelefone");
		
		response.addCookie(new Cookie("cookieId", id));
		response.addCookie(new Cookie("cookieNome", nome));
		response.addCookie(new Cookie("cookieSobrenome", sobreNome));
		response.addCookie(new Cookie("cookieIdade", idade));
		response.addCookie(new Cookie("cookieTelefone", telefone));		
		
		if (id != null)		
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("manutencao.jsp");
			dispatcher.forward(request, response);
		}
				
	}

	private String getParameter(HttpServletRequest request, String string) {		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	private void update(String idCliente, HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		ClienteDao dao = new ClienteDao();
		List<Cliente> lista = (List<Cliente>) dao.select();
		Cliente cliente = new Cliente();
		cliente.setId(idCliente);
		for (Cliente item : lista) {
			if (item.equals(cliente)) {
				request.setAttribute("cliente", item);
				break;
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("manutencao.jsp");
		dispatcher.forward(request, response);
	}

}
