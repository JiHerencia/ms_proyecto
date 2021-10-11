package com.practica.api.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practica.api.modelo.Cliente;
import com.practica.api.modelo.Empleado;
import com.practica.api.modelo.Venta;
public interface VentaRepository extends JpaRepository<Venta, Long> {

	public List<Venta> findByEmpleado(Empleado empleado);
	public List<Venta> findByCliente(Cliente cliente);
}
	