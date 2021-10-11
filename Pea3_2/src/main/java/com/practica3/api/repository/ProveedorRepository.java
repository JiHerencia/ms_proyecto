package com.practica3.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practica3.api.model.Proveedor;


public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

	/*public List<Producto> findByPedidoInterno(PedidoInterno pedidointerno);
	public List<Producto> findByVenta(Venta venta);
	public List<Producto> findByCompra(Compra compra);*/
	
}
