package com.practica3.api.repository;



//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practica3.api.model.Producto;



public interface ProductoRepository extends JpaRepository<Producto, Long> {

	/*public List<Producto> findByPedidoInterno(PedidoInterno pedidointerno);
	public List<Producto> findByVenta(Venta venta);
	public List<Producto> findByCompra(Compra compra);*/
	
}
