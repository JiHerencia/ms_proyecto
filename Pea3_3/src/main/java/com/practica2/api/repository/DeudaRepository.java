package com.practica2.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practica2.api.model.Deuda;


@Repository
public interface DeudaRepository extends JpaRepository<Deuda, Long> {

	//public List<Deuda> findByVenta(Venta venta);
}
	