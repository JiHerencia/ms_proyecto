package com.practica3.api.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.practica3.api.model.Compra;
import com.practica3.api.model.Proveedor;
import com.practica3.api.repository.CompraRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompraServiceImplement implements CompraService {
	
	
	
	public final CompraRepository compraRepositorio;
	
	@Override
	public List<Compra> ListAllCompra() {
		return compraRepositorio.findAll();
	}

	@Override
	public Compra getCompra(Long id) {
		return compraRepositorio.findById(id).orElse(null);
	}
	
	@Override
	public Compra createCompra(Compra compra) {
		compra.setStatus("CREADO");
		compra.setCreateAt(new Date());
		//producto.setHora(null);
		return compraRepositorio.save(compra);
	}

	@Override
	public Compra updateCompra(Compra compra) {
		Compra compraUpdate = getCompra(compra.getIdcompra());
		
		if(compraUpdate == null) {
			return null;
		}
		
		compraUpdate.setTotalcompra(compra.getTotalcompra());
		compraUpdate.setEstadocompra(compra.getEstadocompra());
		//compraUpdate.setEmpleado(compra.getEmpleado());
		compraUpdate.setProveedor(compra.getProveedor());

		
		return compraRepositorio.save(compraUpdate);
	}

	@Override
	public Compra deleteCompra(Long id) {
		Compra compraDelete = getCompra(id);
		
		if(compraDelete == null) {
			return null;
		}
		
		compraDelete.setStatus("ELIMINADO");
		
		return compraRepositorio.save(compraDelete);
	}

	@Override
	public List<Compra> findByProveedor(Proveedor proveedor) {
		return compraRepositorio.findByProveedor(proveedor);
	}
	/*@Override
	public List<Compra> findByEmpleado(Empleado empleado) {
		return compraRepositorio.findByEmpleado(empleado);
	}

	/*@Override
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