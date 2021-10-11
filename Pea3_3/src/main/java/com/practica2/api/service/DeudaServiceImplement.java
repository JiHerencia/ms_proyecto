package com.practica2.api.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.practica2.api.model.Deuda;
import com.practica2.api.repository.DeudaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeudaServiceImplement implements DeudaService {
	
	
	
	public final DeudaRepository ventaRepositorio;
	
	@Override
	public List<Deuda> ListAllDeuda() {
		return ventaRepositorio.findAll();
	}

	@Override
	public Deuda getDeuda(Long id) {
		return ventaRepositorio.findById(id).orElse(null);
	}
	
	@Override
	public Deuda createDeuda(Deuda venta) {
		venta.setStatus("CREADO");
		//venta.setFechavencimiento(new Date());
		//producto.setHora(null);
		return ventaRepositorio.save(venta);
	}

	@Override
	public Deuda updateDeuda(Deuda venta) {
		Deuda ventaUpdate = getDeuda(venta.getIddeuda());
		
		if(ventaUpdate == null) {
			return null;
		}
		
		//ventaUpdate.setVenta(venta.getVenta());
		ventaUpdate.setEstado(venta.getEstado());
		ventaUpdate.setFechavencimiento(venta.getFechavencimiento());
	
		return ventaRepositorio.save(ventaUpdate);
	}

	@Override
	public Deuda deleteDeuda(Long id) {
		Deuda ventaDelete = getDeuda(id);
		
		if(ventaDelete == null) {
			return null;
		}
		
		ventaDelete.setStatus("ELIMINADO");
		
		return ventaRepositorio.save(ventaDelete);
	}

	/*@Override
	public List<Deuda> findByVenta(Venta venta){
		return ventaRepositorio.findByVenta(venta);
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