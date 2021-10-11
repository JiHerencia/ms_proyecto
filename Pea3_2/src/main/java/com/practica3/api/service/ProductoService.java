package com.practica3.api.service;

import java.util.List;

import com.practica3.api.model.Producto;

public interface ProductoService {
	public List<Producto> ListAllProduct();
	public Producto getProduct(Long id);
	
	public Producto createProducto(Producto producto);
	public Producto updateProduct(Producto producto);
	public Producto deleteProducto(Long id);
	
	//public List<Producto> findByCategoria(Categoria categoria);
	
	public Producto updateStock(Long id, Double quantity);
}


