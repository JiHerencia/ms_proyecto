package com.practica3.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practica3.api.model.Compra;
import com.practica3.api.model.DetalleCompra;
import com.practica3.api.model.Producto;
import com.practica3.api.repository.DetalleCompraRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DetalleCompraServiceImplement implements DetalleCompraService {
	
	
	
	public final DetalleCompraRepository detalleventaRepositorio;
	
	@Override
	public List<DetalleCompra> ListAllDetalleCompra() {
		return detalleventaRepositorio.findAll();
	}

	@Override
	public DetalleCompra getDetalleCompra(Long id) {
		return detalleventaRepositorio.findById(id).orElse(null);
	}
	
	@Override
	public DetalleCompra createDetalleCompra(DetalleCompra detallecompra) {
		detallecompra.setStatus("CREADO");
		//detalleventa.setCreateAt(new Date());
		//producto.setHora(null);
		return detalleventaRepositorio.save(detallecompra);
	}

	@Override
	public DetalleCompra updateDetalleCompra(DetalleCompra detallecompra) {
		DetalleCompra detalleventaUpdate = getDetalleCompra(detallecompra.getIddetallecompra());
		
		if(detalleventaUpdate == null) {
			return null;
		}
		
		detalleventaUpdate.setCantidad(detallecompra.getCantidad());
		detalleventaUpdate.setIgv(detallecompra.getIgv());
		detalleventaUpdate.setSubtotal(detallecompra.getSubtotal());
		detalleventaUpdate.setProducto(detallecompra.getProducto());
		detalleventaUpdate.setCompra(detallecompra.getCompra());
		
		return detalleventaRepositorio.save(detalleventaUpdate);
	}

	@Override
	public DetalleCompra deleteDetalleCompra(Long id) {
		DetalleCompra detalleventaDelete = getDetalleCompra(id);
		
		if(detalleventaDelete == null) {
			return null;
		}
		
		detalleventaDelete.setStatus("ELIMINADO");
		
		return detalleventaRepositorio.save(detalleventaDelete);
	}

	@Override
	public List<DetalleCompra> findByProducto(Producto producto) {
		return detalleventaRepositorio.findByProducto(producto);
	}
	@Override
	public List<DetalleCompra> findByCompra(Compra compra) {
		return detalleventaRepositorio.findByCompra(compra);
	}

	/*@Override
	public Producto updateStock(Long id, Double quantity) {
		Producto productoUpdateStock = getProduct(id);
		
		if(productoUpdateStock == null) {
			return null;
		}
		
		Double stock = productoUpdateStock.getStock() + quantity;
		
		productoUpdateStock.setStock(stock);
		
		return productoRepositorio.save(productoUpdateStock);
	}*/
	
}