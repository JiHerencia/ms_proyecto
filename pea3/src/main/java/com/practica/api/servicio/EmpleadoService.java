package com.practica.api.servicio;

import java.util.List;

import com.practica.api.modelo.Empleado;

public interface EmpleadoService {
	public List<Empleado> ListAllEmpleado();
	public Empleado getEmpleado(Long id);
	
	public Empleado createEmpleado(Empleado empleado);
	public Empleado updateEmpleado(Empleado empleado);
	public Empleado deleteEmpleado(Long id);
	
	//public List<Producto> findByCategoria(Categoria categoria);
	
	//public Cliente updateStock(Long id, Double quantity);
}
