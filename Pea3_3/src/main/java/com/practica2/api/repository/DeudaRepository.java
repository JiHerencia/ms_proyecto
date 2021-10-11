package com.practica2.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practica2.api.model.Deuda;



public interface DeudaRepository extends JpaRepository<Deuda, Long> {

	//public List<Deuda> findByVenta(Venta venta);
}
	