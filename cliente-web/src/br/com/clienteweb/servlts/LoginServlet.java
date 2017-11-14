package br.com.clienteweb.servlts;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
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
	
		String user = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		Usuario usuario = new Usuario(user, senha);
		UsuarioDao usuarioDao = new UsuarioDao();
		
		List<Usuario> listaUsuario = (List<Usuario>) usuarioDao.select();		
				
		boolean autenticado = false;
		
		for (Usuario item : listaUsuario) {
			if(item.getUsuario().equals(user) && item.getSenha().equals(senha))
				{
					autenticado = true;
					break;
				}
		}
		
		RequestDispatcher dispatcher = null;
		if(autenticado) {			
			dispatcher = request.getRequestDispatcher("/WebContent/index.jsp");
		} 
		else 
		{
			dispatcher = request.getRequestDispatcher("/WebContent/login.jsp");
		}
		
		dispatcher.forward(request, response);
		
		
//		if (listaUsuario.contains(usuario))
//		out.write("Usuário logado com sucesso.");
//	else {
//		out.write("Não foi possível efetuar o login.");
//	}
					
		
	}

}
