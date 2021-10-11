package com.practica.api.servicio;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.practica.api.modelo.Cliente;

import com.practica.api.modelo.Empleado;

//import com.practica.api.modelo.Proveedor;
import com.practica.api.modelo.Sugerencia;

import com.practica.api.repositorio.SugerenciaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SugerenciaServiceImplement implements SugerenciaService {
	
	
	
	public final SugerenciaRepository detalleventaRepositorio;
	
	@Override
	public List<Sugerencia> ListAllSugerencia() {
		return detalleventaRepositorio.findAll();
	}

	@Override
	public Sugerencia getSugerencia(Long id) {
		return detalleventaRepositorio.findById(id).orElse(null);
	}
	
	@Override
	public Sugerencia createSugerencia(Sugerencia detalleventa) {
		detalleventa.setStatus("CREADO");
		detalleventa.setCreateAt(new Date());
		//producto.setHora(null);
		return detalleventaRepositorio.save(detalleventa);
	}

	@Override
	public Sugerencia updateSugerencia(Sugerencia detalleventa) {
		Sugerencia detalleventaUpdate = getSugerencia(detalleventa.getIdsugerencia());
		
		if(detalleventaUpdate == null) {
			return null;
		}
		
		detalleventaUpdate.setCaso(detalleventa.getCaso());
		detalleventaUpdate.setDescripcion(detalleventa.getDescripcion());
		detalleventaUpdate.setCliente(detalleventa.getCliente());
		detalleventaUpdate.setEmpleado(detalleventa.getEmpleado());
		
		return detalleventaRepositorio.save(detalleventaUpdate);
	}

	@Override
	public Sugerencia deleteSugerencia(Long id) {
		Sugerencia detalleventaDelete = getSugerencia(id);
		
		if(detalleventaDelete == null) {
			return null;
		}
		
		detalleventaDelete.setStatus("ELIMINADO");
		
		return detalleventaRepositorio.save(detalleventaDelete);
	}

	/*@Override
	public List<Sugerencia> findByProveedor(Proveedor proveedor) {
		return detalleventaRepositorio.findByProveedor(proveedor);
	}*/
	@Override
	public List<Sugerencia> findByEmpleado(Empleado empleado) {
		return detalleventaRepositorio.findByEmpleado(empleado);
	}
	@Override
	public List<Sugerencia> findByCliente(Cliente cliente) {
		return detalleventaRepositorio.findByCliente(cliente);
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