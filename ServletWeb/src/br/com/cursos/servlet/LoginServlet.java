package br.com.cursos.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.write("<html><body>Fiz um Get</body></html>");		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();
		
		String usuarioLocal = "catia";
		String senhaLocal = "catia";
		
		String usuario = req.getParameter("usuario");
		String senha = req.getParameter("senha");
		
		if(usuarioLocal.equals(usuario) && senhaLocal.equals(senha))
			writer.write("Login efetuado com sucesso.");			
		else 
			writer.write("Usuário ou senha inválida.");		
		
	}

}
