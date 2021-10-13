package com.practica3.api.service;

import java.util.List;

import com.practica3.api.model.Compra;
import com.practica3.api.model.Proveedor;



public interface CompraService {
	public List<Compra> ListAllCompra();
	public Compra getCompra(Long id);
	
	public Compra createCompra(Compra compra);
	public Compra updateCompra(Compra compra);
	public Compra deleteCompra(Long id);
	
	public List<Compra> findByProveedor(Proveedor proveedor);
	//public List<Compra> findByEmpleado(Empleado empleado);
	
	//public Producto updateStock(Long id, Double quantity);
}

