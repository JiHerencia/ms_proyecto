package com.practica2.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practica2.api.model.Pago;

public interface PagoRepository extends JpaRepository<Pago, Long> {

	//public List<Pago> findByEmpleado(Empleado empleado);

}
