package com.practica2.api.service;

import java.util.List;

import com.practica2.api.model.Pago;

public interface PagoService {
	
	public List<Pago> ListAllPago();
	public Pago getPago(Long id);	
	public Pago createPago(Pago pago);
	public Pago updatePago(Pago pago);
	public Pago deletePago(Long id);
		
	//public List<Pago> findByEmpleado(Empleado empleado);
}
