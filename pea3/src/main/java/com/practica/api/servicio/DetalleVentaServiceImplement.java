package com.practica.api.servicio;

import java.util.List;

import org.springframework.stereotype.Service;


import com.practica.api.modelo.DetalleVenta;

import com.practica.api.modelo.Venta;
import com.practica.api.repositorio.DetalleVentaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DetalleVentaServiceImplement implements DetalleVentaService {

	public final DetalleVentaRepository detalleventaRepositorio;
	
	@Override
	public List<DetalleVenta> ListAllDetalleVenta() {
		return detalleventaRepositorio.findAll();
	}

	@Override
	public DetalleVenta getDetalleVenta(Long id) {
		return detalleventaRepositorio.findById(id).orElse(null);
	}
	
	@Override
	public DetalleVenta createDetalleVenta(DetalleVenta detalleventa) {
		detalleventa.setStatus("CREADO");
		//detalleventa.setCreateAt(new Date());
		//producto.setHora(null);
		return detalleventaRepositorio.save(detalleventa);
	}

	@Override
	public DetalleVenta updateDetalleVenta(DetalleVenta detalleventa) {
		DetalleVenta detalleventaUpdate = getDetalleVenta(detalleventa.getIddetalleventa());
		
		if(detalleventaUpdate == null) {
			return null;
		}
		
		detalleventaUpdate.setCantidad(detalleventa.getCantidad());
		detalleventaUpdate.setIgv(detalleventa.getIgv());
		detalleventaUpdate.setSubtotal(detalleventa.getSubtotal());
		//detalleventaUpdate.setProducto(detalleventa.getProducto());
		detalleventaUpdate.setVenta(detalleventa.getVenta());
		
		return detalleventaRepositorio.save(detalleventaUpdate);
	}

	@Override
	public DetalleVenta deleteDetalleVenta(Long id) {
		DetalleVenta detalleventaDelete = getDetalleVenta(id);
		
		if(detalleventaDelete == null) {
			return null;
		}
		
		detalleventaDelete.setStatus("ELIMINADO");
		
		return detalleventaRepositorio.save(detalleventaDelete);
	}

	/*@Override
	public List<DetalleVenta> findByProducto(Producto producto) {
		return detalleventaRepositorio.findByProducto(producto);
	}*/
	@Override
	public List<DetalleVenta> findByVenta(Venta venta) {
		return detalleventaRepositorio.findByVenta(venta);
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