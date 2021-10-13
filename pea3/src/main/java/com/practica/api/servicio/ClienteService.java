package com.practica.api.servicio;

import java.util.List;

import com.practica.api.modelo.Cliente;


public interface ClienteService {

	public List<Cliente> ListAllCliente();
	public Cliente getCliente(Long id);
	
	public Cliente createCliente(Cliente cliente);
	public Cliente updateCliente(Cliente cliente);
	public Cliente deleteCliente(Long id);
	
	//public List<Producto> findByCategoria(Categoria categoria);
	
	//public Cliente updateStock(Long id, Double quantity);
}



