package com.practica.api.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practica.api.modelo.DetalleVenta;
//import com.practica.api.modelo.Producto;
import com.practica.api.modelo.Venta;
@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {

	public List<DetalleVenta> findByVenta(Venta venta);
	//public List<DetalleVenta> findByProducto(Producto producto);

	
}
