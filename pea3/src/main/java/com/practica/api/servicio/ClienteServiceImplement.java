package com.practica.api.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practica.api.modelo.Cliente;

import com.practica.api.repositorio.ClienteRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServiceImplement implements ClienteService {
	
	
	public final ClienteRepository clienteRepositorio;
	
	@Override
	public List<Cliente> ListAllCliente() {
		return clienteRepositorio.findAll();
	}

	@Override
	public Cliente getCliente(Long id) {
		return clienteRepositorio.findById(id).orElse(null);
	}
	
	@Override
	public Cliente createCliente(Cliente cliente) {
		cliente.setStatus("CREADO");
	//	producto.setCreateAt(new Date());
		//producto.setHora(null);
		return clienteRepositorio.save(cliente);
	}

	@Override
	public Cliente updateCliente(Cliente cliente) {
		Cliente clienteUpdate = getCliente(cliente.getIdcliente());
		
		if(clienteUpdate == null) {
			return null;
		}
		
		clienteUpdate.setNombrecliente(cliente.getNombrecliente());
		clienteUpdate.setDni(cliente.getDni());

		return clienteRepositorio.save(clienteUpdate);
	}

	@Override
	public Cliente deleteCliente(Long id) {
		Cliente clienteDelete = getCliente(id);
		
		if(clienteDelete == null) {
			return null;
		}
		
		clienteDelete.setStatus("ELIMINADO");
		
		return clienteRepositorio.save(clienteDelete);
	}

	/*@Override
	public List<Producto> findByCategoria(Categoria categoria) {
		return productoRepositorio.findByCategoria(categoria);
	}

	@Override
	public Producto updateStock(Long id, Double quantity) {
		Producto productoUpdateStock = getProduct(id);
		
		if(productoUpdateStock == null) {
			return null;
		}
		
		Double stock = productoUpdateStock.getStock() + quantity;
		
		productoUpdateStock.setStock(stock);
		
		return productoRepositorio.save(productoUpdateStock);
	}*/

}