package com.practica3.api.service;

import java.util.List;

import com.practica3.api.model.Proveedor;


public interface ProveedorService {
	public List<Proveedor> ListAllProduct();
	public Proveedor getProduct(Long id);
	
	public Proveedor createProducto(Proveedor proveedor);
	public Proveedor updateProduct(Proveedor proveedor);
	public Proveedor deleteProducto(Long id);
	
	//public List<Producto> findByCategoria(Categoria categoria);
	
	//public Producto updateStock(Long id, Double quantity);
}


