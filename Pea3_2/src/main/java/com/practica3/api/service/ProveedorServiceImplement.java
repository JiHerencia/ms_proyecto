package com.practica3.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practica3.api.model.Proveedor;
import com.practica3.api.repository.ProveedorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProveedorServiceImplement implements ProveedorService {
	
	
	public final ProveedorRepository productoRepositorio;
	
	@Override
	public List<Proveedor> ListAllProduct() {
		return productoRepositorio.findAll();
	}

	@Override
	public Proveedor getProduct(Long id) {
		return productoRepositorio.findById(id).orElse(null);
	}
	
	@Override
	public Proveedor createProducto(Proveedor proveedor) {
		proveedor.setStatus("CREADO");
	//	producto.setCreateAt(new Date());
		//producto.setHora(null);
		return productoRepositorio.save(proveedor);
	}

	@Override
	public Proveedor updateProduct(Proveedor proveedor) {
		Proveedor productoUpdate = getProduct(proveedor.getIdproveedor());
		
		if(productoUpdate == null) {
			return null;
		}
		
		productoUpdate.setNombreproveedor(proveedor.getNombreproveedor());
		productoUpdate.setRuc(proveedor.getRuc());
		productoUpdate.setCorreo(proveedor.getCorreo());
		
		return productoRepositorio.save(productoUpdate);
	}

	@Override
	public Proveedor deleteProducto(Long id) {
		Proveedor productoDelete = getProduct(id);
		
		if(productoDelete == null) {
			return null;
		}
		
		productoDelete.setStatus("ELIMINADO");
		
		return productoRepositorio.save(productoDelete);
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