package com.practica3.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practica3.api.model.Compra;
import com.practica3.api.model.DetalleCompra;
import com.practica3.api.model.Producto;


@Repository
public interface DetalleCompraRepository extends JpaRepository<DetalleCompra, Long> {

	public List<DetalleCompra> findByCompra(Compra compra);
	public List<DetalleCompra> findByProducto(Producto producto);	
}
