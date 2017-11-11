package br.com.cliente.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.cliente.model.Cliente;

public class ClienteDao {
	
	private List<Cliente> clientes;
	
	public ClienteDao() {
		initMock();
	}
	
	private void initMock() {
		
//		clientes = new ArrayList<Cliente>();
//		
//		Cliente  cliente1 = new Cliente();
//		cliente1.setId(1);
//		cliente1.setNome("Jan");
//		cliente1.setSobreNome("Nascimento");
//		cliente1.setIdade(18);
//		cliente1.setTelefone("99999999");		
//		
//		clientes.add(cliente1);
		
		clientes = new ArrayList<Cliente>();
		clientes.add(new Cliente(1, "Jandeilson", "Nascimento", 30, "9999-9999"));
		clientes.add(new Cliente(2, "Catia", "Silva", 18, "8888-8888"));
		clientes.add(new Cliente(3, "Helvio", "Ferreira", 15, "7777-7777"));
		
		
	}
	
	public List<Cliente> obterTodosClientes(){
		return this.clientes;
	}

}
