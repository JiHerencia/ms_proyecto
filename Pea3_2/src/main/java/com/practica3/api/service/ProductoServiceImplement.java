package com.practica3.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practica3.api.model.Producto;
import com.practica3.api.repository.ProductoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoServiceImplement implements ProductoService {
	
	
	public final ProductoRepository productoRepositorio;
	
	@Override
	public List<Producto> ListAllProduct() {
		return productoRepositorio.findAll();
	}

	@Override
	public Producto getProduct(Long id) {
		return productoRepositorio.findById(id).orElse(null);
	}
	
	@Override
	public Producto createProducto(Producto producto) {
		producto.setStatus("CREADO");
	//	producto.setCreateAt(new Date());
		//producto.setHora(null);
		return productoRepositorio.save(producto);
	}

	@Override
	public Producto updateProduct(Producto producto) {
		Producto productoUpdate = getProduct(producto.getIdproducto());
		
		if(productoUpdate == null) {
			return null;
		}
		
		productoUpdate.setNombreproducto(producto.getNombreproducto());
		productoUpdate.setMarcaproducto(producto.getMarcaproducto());
		productoUpdate.setStock(producto.getStock());
		productoUpdate.setPrecio(producto.getPrecio());
		productoUpdate.setVence(producto.getVence());
		
		return productoRepositorio.save(productoUpdate);
	}

	@Override
	public Producto deleteProducto(Long id) {
		Producto productoDelete = getProduct(id);
		
		if(productoDelete == null) {
			return null;
		}
		
		productoDelete.setStatus("ELIMINADO");
		
		return productoRepositorio.save(productoDelete);
	}

	/*@Override
	public List<Producto> findByCategoria(Categoria categoria) {
		return productoRepositorio.findByCategoria(categoria);
	}*/

	@Override
	public Producto updateStock(Long id, Double quantity) {
		Producto productoUpdateStock = getProduct(id);
		
		if(productoUpdateStock == null) {
			return null;
		}
		
		Double stock = productoUpdateStock.getStock() + quantity;
		
		productoUpdateStock.setStock(stock);
		
		return productoRepositorio.save(productoUpdateStock);
	}

}