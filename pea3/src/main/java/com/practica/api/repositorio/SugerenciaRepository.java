package com.practica.api.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practica.api.modelo.Cliente;
import com.practica.api.modelo.Empleado;
//import com.practica.api.modelo.Proveedor;
import com.practica.api.modelo.Sugerencia;
@Repository
public interface SugerenciaRepository  extends JpaRepository<Sugerencia, Long> {

	public List<Sugerencia> findByEmpleado(Empleado empleado);
	public List<Sugerencia> findByCliente(Cliente cliente);
	//public List<Sugerencia> findByProveedor(Proveedor proveedor);
	

}
