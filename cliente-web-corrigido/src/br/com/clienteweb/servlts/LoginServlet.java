package br.com.clienteweb.servlts;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cliente.model.Usuario;
import br.com.cliente.dao.UsuarioDao;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		UsuarioDao usuarioDao = new UsuarioDao();		
		
		@SuppressWarnings("unchecked")
		List<Usuario> listaUsuario = (List<Usuario>) usuarioDao.select();		
				
		boolean autenticado = false;
		
		for (Usuario item : listaUsuario) {
			if(item.getUsuario().equals(usuario) && item.getSenha().equals(senha))
				{
					autenticado = true;
					break;
				}
		}
		
		PrintWriter out = response.getWriter();
		RequestDispatcher dispatcher = null;
		
		if(autenticado) {			
			dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		} 
		else 
		{
			
			dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.include(request, response);	
			out.println("<b><center>Usuário ou senha inválida.</center></b>");
		}		
				
	}

}
