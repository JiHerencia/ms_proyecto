package com.practica3.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practica3.api.model.Compra;
import com.practica3.api.model.Proveedor;


@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

	//public List<Compra> findByEmpleado(Empleado empleado);
	public List<Compra> findByProveedor(Proveedor proveedor);
}
	