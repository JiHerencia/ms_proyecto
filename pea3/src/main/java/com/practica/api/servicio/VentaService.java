package com.practica.api.servicio;

import java.util.List;

import com.practica.api.modelo.Cliente;
import com.practica.api.modelo.Empleado;
import com.practica.api.modelo.Venta;

public interface VentaService {
	public List<Venta> ListAllVenta();
	public Venta getVenta(Long id);
	
	public Venta createVenta(Venta venta);
	public Venta updateVenta(Venta venta);
	public Venta deleteVenta(Long id);
	
	public List<Venta> findByCliente(Cliente cliente);
	public List<Venta> findByEmpleado(Empleado empleado);
	
	//public Producto updateStock(Long id, Double quantity);
}

