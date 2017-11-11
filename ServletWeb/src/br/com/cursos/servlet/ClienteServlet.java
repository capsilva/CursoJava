package br.com.cursos.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// private List<String> clientes;

	// public void init() throws ServletException{ loadClientes(); }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// PrintWriter writer = resp.getWriter();
		// writer.write("<html><body>Meu Primeiro Servlet</body></html>");

		// PrintWriter writer = resp.getWriter(); writer.write("<html><body>");
		// writer.write("<ul>"); for (String item : clientes) { writer.write("<li>" +
		// item + "</li>"); } writer.write("</ul>"); writer.write("</body></html>");

		String filtro = req.getParameter("filtro");
		List<String> resultado = filtrarClientes(filtro);

		PrintWriter writer = resp.getWriter();

		writer.write("<html><body>");
		writer.write("<ul>");
		for (String item : resultado) {
			writer.write("<li>" + item + "</li>");
		}
		writer.write("</ul>");
		writer.write("</body></html>");

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	// private void loadClientes() {
	// clientes = new ArrayList<String>();
	// clientes.add("Cátia");
	// clientes.add("Hélvio");
	// clientes.add("Jandeilson");
	// clientes.add("Allan");
	// clientes.add("Ismael");
	// }

	private List<String> filtrarClientes(String filtro) {

		List<String> clientes = new ArrayList<String>();
		List<String> listaFiltrada = new ArrayList<String>();

		clientes.add("Catia");
		clientes.add("Catia Silva");
		clientes.add("Helvio");
		clientes.add("Jandeilson");
		clientes.add("Allan");
		clientes.add("Ismael");

		if (!filtro.equals("")) {
			for (String cliente : clientes) {
				if (cliente.toUpperCase().contains(filtro.toUpperCase()))
					listaFiltrada.add(cliente);
			}
		} else {
			listaFiltrada = clientes;
		}

		return listaFiltrada;

	}

}
