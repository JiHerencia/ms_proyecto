package com.practica.api.servicio;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.practica.api.modelo.Cliente;
import com.practica.api.modelo.Empleado;
import com.practica.api.modelo.Venta;
import com.practica.api.repositorio.VentaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VentaServiceImplement implements VentaService {
	
	
	
	public final VentaRepository ventaRepositorio;
	
	@Override
	public List<Venta> ListAllVenta() {
		return ventaRepositorio.findAll();
	}

	@Override
	public Venta getVenta(Long id) {
		return ventaRepositorio.findById(id).orElse(null);
	}
	
	@Override
	public Venta createVenta(Venta venta) {
		venta.setStatus("CREADO");
		venta.setCreateAt(new Date());
		//producto.setHora(null);
		return ventaRepositorio.save(venta);
	}

	@Override
	public Venta updateVenta(Venta venta) {
		Venta ventaUpdate = getVenta(venta.getIdventa());
		
		if(ventaUpdate == null) {
			return null;
		}
		
		ventaUpdate.setTotalventa(venta.getTotalventa());
		ventaUpdate.setEmpleado(venta.getEmpleado());
		ventaUpdate.setCliente(venta.getCliente());

		
		return ventaRepositorio.save(ventaUpdate);
	}

	@Override
	public Venta deleteVenta(Long id) {
		Venta ventaDelete = getVenta(id);
		
		if(ventaDelete == null) {
			return null;
		}
		
		ventaDelete.setStatus("ELIMINADO");
		
		return ventaRepositorio.save(ventaDelete);
	}

	@Override
	public List<Venta> findByCliente(Cliente cliente) {
		return ventaRepositorio.findByCliente(cliente);
	}
	@Override
	public List<Venta> findByEmpleado(Empleado empleado) {
		return ventaRepositorio.findByEmpleado(empleado);
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