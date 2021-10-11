package com.practica2.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practica2.api.model.DetalleDeudaPago;
import com.practica2.api.model.Deuda;
import com.practica2.api.model.Pago;
import com.practica2.api.repository.DetalleDeudaPagoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DetalleDeudaServiceImplement implements DetalleDeudaPagoService {
	
	public final DetalleDeudaPagoRepository detalleventaRepositori;
	
	@Override
	public List<DetalleDeudaPago> ListAllDetalleDeudaPago() {
		return detalleventaRepositori.findAll();
	}

	@Override
	public DetalleDeudaPago getDetalleDeudaPago(Long id) {
		return detalleventaRepositori.findById(id).orElse(null);
	}
	
	@Override
	public DetalleDeudaPago createDetalleDeudaPago(DetalleDeudaPago detalleventa) {
		detalleventa.setStatus("CREADO");
		//detalleventa.setCreateAt(new Date());
		//producto.setHora(null);
		return detalleventaRepositori.save(detalleventa);
	}

	@Override
	public DetalleDeudaPago updateDetalleDeudaPago(DetalleDeudaPago  detalleventa) {
		DetalleDeudaPago detalleventaUpdate = getDetalleDeudaPago(detalleventa.getIddetalle());
		
		if(detalleventaUpdate == null) {
			return null;
		}
		
		detalleventaUpdate.setPago(detalleventa.getPago());
		detalleventaUpdate.setDeuda(detalleventa.getDeuda());
		detalleventaUpdate.setPreciomora(detalleventa.getPreciomora());
		//detalleventaUpdate.setProducto(detalleventa.getProducto());
		detalleventaUpdate.setDiasretraso(detalleventa.getDiasretraso());
		
		return detalleventaRepositori.save(detalleventaUpdate);
	}
 
	@Override
	public DetalleDeudaPago deleteDetalleDeudaPago(Long id) {
		DetalleDeudaPago detalleventaDelete = getDetalleDeudaPago(id);
		
		if(detalleventaDelete == null) {
			return null;
		}
		
		detalleventaDelete.setStatus("ELIMINADO");
		
		return detalleventaRepositori.save(detalleventaDelete);
	}

	@Override
	public List<DetalleDeudaPago> findByPago(Pago producto) {
		return detalleventaRepositori.findByPago(producto);
	}
	@Override
	public List<DetalleDeudaPago> findByDeuda(Deuda venta) {
		return detalleventaRepositori.findByDeuda(venta);
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

