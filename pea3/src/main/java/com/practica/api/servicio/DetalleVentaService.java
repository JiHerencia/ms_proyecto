package com.practica.api.servicio;

import java.util.List;

import com.practica.api.modelo.DetalleVenta;
//import com.practica.api.modelo.Producto;
import com.practica.api.modelo.Venta;

public interface DetalleVentaService {

	public List<DetalleVenta> ListAllDetalleVenta();
	public DetalleVenta getDetalleVenta(Long id);
	
	public DetalleVenta createDetalleVenta(DetalleVenta detalleventa);
	public DetalleVenta updateDetalleVenta(DetalleVenta detalleventa);
	public DetalleVenta deleteDetalleVenta(Long id);
	
	//public List<DetalleVenta> findByProducto(Producto producto);
	public List<DetalleVenta> findByVenta(Venta venta);
	//public Cliente updateStock(Long id, Double quantity);
}
