package com.practica2.api.service;

import java.util.List;

import com.practica2.api.model.Deuda;


public interface DeudaService {
	public List<Deuda> ListAllDeuda();
	public Deuda getDeuda(Long id);
	
	public Deuda createDeuda(Deuda deuda);
	public Deuda updateDeuda(Deuda deuda);
	public Deuda deleteDeuda(Long id);
	
	//public List<Deuda> findByVenta(Venta venta);
	
	
	//public Producto updateStock(Long id, Double quantity);
}

