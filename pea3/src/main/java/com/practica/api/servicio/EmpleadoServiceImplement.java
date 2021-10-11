package com.practica.api.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practica.api.modelo.Empleado;
import com.practica.api.repositorio.EmpleadoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImplement implements EmpleadoService {
	
	
	public final EmpleadoRepository empleadoRepositorio;
	
	@Override
	public List<Empleado> ListAllEmpleado() {
		return empleadoRepositorio.findAll();
	}

	@Override
	public Empleado getEmpleado(Long id) {
		return empleadoRepositorio.findById(id).orElse(null);
	}
	
	@Override
	public Empleado createEmpleado(Empleado empleado) {
		empleado.setStatus("CREADO");
	//	producto.setCreateAt(new Date());
		//producto.setHora(null);
		return empleadoRepositorio.save(empleado);
	}

	@Override
	public Empleado updateEmpleado(Empleado empleado) {
		Empleado empleadoUpdate = getEmpleado(empleado.getIdempleado());
		
		if(empleadoUpdate == null) {
			return null;
		}
		
		empleadoUpdate.setNombreempleado(empleado.getNombreempleado());
		empleadoUpdate.setDni(empleado.getDni());

		return empleadoRepositorio.save(empleadoUpdate);
	}

	@Override
	public Empleado deleteEmpleado(Long id) {
		Empleado empleadoDelete = getEmpleado(id);
		
		if(empleadoDelete == null) {
			return null;
		}
		
		empleadoDelete.setStatus("ELIMINADO");
		
		return empleadoRepositorio.save(empleadoDelete);
	}

	/*@Override
	public List<Producto> findByCategoria(Categoria categoria) {
		return productoRepositorio.findByCategoria(categoria);
	}

	@Override
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