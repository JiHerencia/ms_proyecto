package com.practica2.api.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.practica2.api.model.Pago;
import com.practica2.api.repository.PagoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PagoServiceImplement implements PagoService {
	
	
	
	public final PagoRepository ventaRepositorio;
	
	@Override
	public List<Pago> ListAllPago() {
		return ventaRepositorio.findAll();
	}

	@Override
	public Pago getPago(Long id) {
		return ventaRepositorio.findById(id).orElse(null);
	}
	
	@Override
	public Pago createPago(Pago venta) {
		venta.setStatus("CREADO");
		venta.setCreateAt(new Date());
		//producto.setHora(null);
		return ventaRepositorio.save(venta);
	}

	@Override
	public Pago updatePago(Pago venta) {
		Pago ventaUpdate = getPago(venta.getIdpago());
		
		if(ventaUpdate == null) {
			return null;
		}
		
		//ventaUpdate.setEmpleado(venta.getEmpleado());
		ventaUpdate.setTotalpago(venta.getTotalpago());
		ventaUpdate.setCreateAt(venta.getCreateAt());

		return ventaRepositorio.save(ventaUpdate);
	}

	@Override
	public Pago deletePago(Long id) {
		Pago ventaDelete = getPago(id);
		
		if(ventaDelete == null) {
			return null;
		}
		
		ventaDelete.setStatus("ELIMINADO");
		
		return ventaRepositorio.save(ventaDelete);
	}

	/*@Override
	public List<Pago> findByEmpleado(Empleado venta){
		return ventaRepositorio.findByEmpleado(venta);
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