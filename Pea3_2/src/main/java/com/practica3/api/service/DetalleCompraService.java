package com.practica3.api.service;

import java.util.List;

import com.practica3.api.model.Compra;
import com.practica3.api.model.DetalleCompra;
import com.practica3.api.model.Producto;


public interface DetalleCompraService {

	public List<DetalleCompra> ListAllDetalleCompra();
	public DetalleCompra getDetalleCompra(Long id);
	
	public DetalleCompra createDetalleCompra(DetalleCompra detallecompra);
	public DetalleCompra updateDetalleCompra(DetalleCompra detallecompra);
	public DetalleCompra deleteDetalleCompra(Long id);
	
	public List<DetalleCompra> findByProducto(Producto producto);
	public List<DetalleCompra> findByCompra(Compra compra);
	//public Cliente updateStock(Long id, Double quantity);
}
