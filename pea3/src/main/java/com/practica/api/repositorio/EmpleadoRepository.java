package com.practica.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practica.api.modelo.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

	/*public List<Producto> findByPedidoInterno(PedidoInterno pedidointerno);
	public List<Producto> findByVenta(Venta venta);
	public List<Producto> findByCompra(Compra compra);*/
	
}
