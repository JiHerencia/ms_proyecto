package com.practica.api.servicio;

import java.util.List;

import com.practica.api.modelo.Cliente;

import com.practica.api.modelo.Empleado;

//import com.practica.api.modelo.Proveedor;
import com.practica.api.modelo.Sugerencia;

public interface SugerenciaService {

	public List<Sugerencia> ListAllSugerencia();
	public Sugerencia getSugerencia(Long id);
	
	public Sugerencia createSugerencia(Sugerencia sugerencia);
	public Sugerencia updateSugerencia(Sugerencia sugerencia);
	public Sugerencia deleteSugerencia(Long id);
	
	public List<Sugerencia> findByEmpleado(Empleado empleado);
	//public List<Sugerencia> findByProveedor(Proveedor proveedor);
	public List<Sugerencia> findByCliente(Cliente cliente);
	//public Cliente updateStock(Long id, Double quantity);
}
