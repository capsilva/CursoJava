package br.com.cliente.dao;

import java.util.ArrayList;
import java.util.List;
import br.com.cliente.model.Usuario;

public class UsuarioDao implements IDefaultDao {

	private List<Usuario> mockUsuarios;
	
	public UsuarioDao() {
		mockUsuarios = new ArrayList<Usuario>();
		mockUsuarios.add(new Usuario ("catia", "123456"));
		mockUsuarios.add(new Usuario ("helvio", "123"));
	}
	
	@Override
	public void insert() {			
	}

	@Override
	public boolean update() {
		return false;
	}

	@Override
	public List<?> select() {		
		return this.mockUsuarios;
	}

	@Override
	public boolean delete() {		
		return false;
	}

}
